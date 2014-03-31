<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %> <!-- cette bib est decrite ds un fichier(*.tld) sur glassfisg en format xml -->
<!DOCTYPE HTML>
<html lang ="fr">
<head>   
	<title>Saisie dvd</title>
	<meta charset = "UTF-8" />
	<c:url var = "jQuery"    value="/_js/libs/jquery-1.10.2.min.js"/>
	<c:url var = "js"        value="/_js/valider.js"/>
	<c:url var = "normalize" value="/_css/normalize.css"/>
	<c:url var = "style"     value="/_css/styles.css"/>
	
	<c:url var = "urlAdd"    value="/dvd/add"/>
	<c:url var = "urlListe"  value="/dvd/liste"/>
	
	<link rel="stylesheet" href="${normalize}" type="text/css" media="screen" />
	<link rel="stylesheet" href="${style}"     type="text/css" media="screen" />
</head>
<body>
	<p id="succes">Il y a actuellement  :${nbvisiteurs} utilisateur(s) connecté(s)</p>
	<form method="post" action="${urlAdd}" id="frmSupport">
		<fieldset>
			<legend>
				Saisie dvd :
			</legend>
			<p>
				<label for="titre">Titre* :</label>
				<input autofocus type="text" name="titre" placeholder="Titre..." id="titre" required="required" value ="${titre}"/>${erreur["titre"] }
			</p>
			<p>
				<label for="isbn">ISBN* :</label>
				<input type="text" name="isbn" placeholder="Isbn..." id="surname" required="required" value ="${isbn}"/>${erreur["isbn"] }
			</p>
			<p>
				<label for="real">Réalisateurs* :</label>
				<input type="text"  name="real" placeholder="Réalisateurs séparés par virgule..." id="real" required="required" value ="${real}"/>${erreur["real"] }
			</p>
			<p>
				<label for="acteur">Acteurs* :</label>
				<input type="text"  name="acteur" placeholder="Acteurs séparés par virgule..." id="acteur" required="required" value ="${acteur}"/>${erreur["acteur"] }
			</p>
			<p>
				<label for="dateDeSortie">Date de sortie* :</label>
				<input type="date"  name="dateDeSortie" placeholder="jj-mm-aaaa" id="dateDeSortie" required="required" value ="${dateDeSortie}"/>${erreur["dateDeSortie"] }
			</p>
			<p>
				<label for="duree">Durée* :</label>
				<input type="text" name="duree" placeholder="Durée..." id="duree" required="required" value ="${duree}"/>${erreur["duree"] }
			</p>
			
      				<p>
      					<label for = "categorie">Catégorie* :</label>
      					<select name="categorie" >
 							<option value="s1" ${s1}>Dramatique</option>
 							<option value="s2" ${s2}>Comédie</option>
 							<option value="s3" ${s3}>Romantique</option>
				</select>
				${erreur["categorie"] }
      				</p>	
			
			<p>
				<input onclick="valider();" type="submit" name="submit" value="Valider" id="submit"/>
				<input type="reset"  name="reset"  value="Réinitialiser" id="reset"/>
			</p>
			<p>
				*Champs obligatoires
			</p>
		</fieldset>
	</form>
	
	<p>
		<a target="" href="${urlListe}">Liste des DVD</a>
	</p>
	
</body>
<script src="${jQuery}" type="text/javascript" charset="utf-8"></script>
<script src="${js}" type="text/javascript" charset="utf-8"></script>

</html>