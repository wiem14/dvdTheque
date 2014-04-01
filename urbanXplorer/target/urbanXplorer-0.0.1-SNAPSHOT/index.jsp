<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %> <!-- cette bib est decrite ds un fichier(*.tld) sur glassfisg en format xml -->

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Index texte</title>
	<c:url var = "urlSearch"    value="/search"/>

</head>
<body>

<form name="findForm" id="findForm" method="post" action="${urlSearch}" >
<p>Find entities with <br>
<table>
<tbody>
	<tr>
    <td><strong>Name:</strong></td>
    <td><input type="text" name="entity" size="40"  placeholder="Texte à chercher..." id="entity" required="required" value ="${entity}"> (required)<br>${erreur["entity"] }</td>
  	</tr>
</tbody>
</table>
	<input type="submit" name="search" value="Search" onclick="startTestSearch(); return false;"/>
	
		
</form>
<div id="testSearchResult">
<pre id="testSearchResultText">
	${result}
</pre>
</div>
<script>
function startTestSearch() {
var relpath = "/find";
var 
	base = window.location.href.replace(/\/$/, "");
		if (base.lastIndexOf(relpath) != (base.length - relpath.length)) {
			base = base + relpath;
		}
		alert (base);
		$("#testSearchResultText").text("... waiting for results ...");
		$("#testSearchResult").show();
		var data = "name=" + $("#testSearchValue").val() + "&limit=10&offset=0";
$.ajax({
			type : "POST",
			beforeSend : function(req) {
				req.setRequestHeader("Accept", $("#findOutputFormat").val());
			},
			url : base,
			data : $("#findForm").serialize(),
			dataType : "text",
			cache : false,
			success : function(result) {
				$("#testSearchResultText").text(result);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				$("#testSearchResultText").text(
						jqXHR.statusText + " - " + jqXHR.responseText);
			}
		});
	}
</script> 
</body>
</html>