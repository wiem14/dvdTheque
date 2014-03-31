<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- cette bib est decrite ds un fichier(*.tld) sur glassfisg en format xml -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Liste dvds</title>
<c:url var="jQuery" value="/_js/libs/jquery-1.10.2.min.js" />
<c:url var="js" value="/_js/valider.js" />
<c:url var="normalize" value="/_css/normalize.css" />
<c:url var="style" value="/_css/styles.css" />
<c:url var="urlAdd" value="/dvd/add" />
<link rel="stylesheet" href="${normalize}" type="text/css"
	media="screen" />
<link rel="stylesheet" href="${style}" type="text/css" media="screen" />
</head>
<body>
	<p id="succes">Il y a actuellement  :${nbvisiteurs} utilisateur(s) connecté(s)</p>
	<p id="succes">${succes}</p>
	<p>Liste des DVDs</p>
	<table id="tabRandos" summary="Liste des DVDs...">
		<caption>Liste des DVDs</caption>
		<!-- legende de tableau -->
		<colgroup>
			<col id="nomRando" />
			<!-- pour le style -->
			<col id="typeRando" />
			<col id="longueurRando" />
			<col id="traceRando" />
			<col id="deniveleRando" />

		</colgroup>
		<thead>
			<tr>
				<th scope="col">Titre</th>
				<!-- scope = col, entete d'une colone -->
				<th scope="col">ISBN</th>
				<th scope="col">Date de sortie</th>
				<th scope="col">Réalisateurs</th>
				<th scope="col">Acteurs</th>
				<th scope="col">Durée</th>
				<th scope="col">Genre</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td colspan="7">Un blabla dans le &lt;tfoot&gt; qui s'étend sur
					plusieurs colonnes.</td>
			</tr>
		</tfoot>
		<tbody>
			<c:forEach var="dvd" items="${dvdsList}">
			<tr>
				<th scope="row">${dvd.titre}</th>
				<td>${dvd.ISBN}</td>
				<td>${dvd.AfficheDate()}</td>
				<td>${dvd.realisateurs}</td>
				<td>${dvd.acteurs}</td>
				<td>${dvd.duree}</td>
				<td>${dvd.categorie.getCatType()}</td>
			<tr>
			</c:forEach>
		</tbody>

	</table>
	
	

	<p>
		<a target="" href="${urlAdd}">Retour au formulaire</a>
	</p>
</body>
<script src="${jQuery}" type="text/javascript" charset="utf-8"></script>
<script src="${js}" type="text/javascript" charset="utf-8"></script>
</html>