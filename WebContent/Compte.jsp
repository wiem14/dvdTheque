<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %> <!-- cette bib est decrite ds un fichier(*.tld) sur glassfisg en format xml -->
<!DOCTYPE HTML>
<html lang ="fr">
<head>   
	<title>Création compte</title>
	<meta charset = "UTF-8" />
	<c:url var = "jQuery"    value="/_js/libs/jquery-1.10.2.min.js"/>
	<c:url var = "js"        value="/_js/valider.js"/>
	<c:url var = "normalize" value="/_css/normalize.css"/>
	<c:url var = "style"     value="/_css/styles.css"/>
	
	<c:url var = "urlAdd"    value="/dvd/add"/>
	<c:url var = "urlConnect"  value="/dvd/liste"/>
	<c:url var = "urlCreate"  value="/compte"/>
	
	<link rel="stylesheet" href="${normalize}" type="text/css" media="screen" />
	<link rel="stylesheet" href="${style}"     type="text/css" media="screen" />
</head>
<body>
	<p id="succes">Il y a actuellement  :${nbvisiteurs} utilisateur(s) connecté(s)</p>
	<form method="post" action="${urlCreate}" id="frmConnection">
		<fieldset>
			<legend>
				Connection :
			</legend>
			<p>
				<label for="login">Login* :</label>
				<input autofocus type="text" name="login" placeholder="" id="login" required="required" value ="${login}"/>${erreur["login"] }
			</p>
			<p>
				<label for="mdp">Mot de passe* :</label>
				<input type="password" name="mdp" placeholder="" id="mdp" required="required" value ="${mdp}"/>${erreur["mdp"] }
			</p>
			
			<p>
				<input type="submit" name="submit" value="Valider" id="submit"/>
				<input type="reset"  name="reset"  value="Réinitialiser" id="reset"/>
			</p>
			<p id="message">${msg}</p>
			<p>
				Déja membre<a target="" href="${urlConnect}">Se connecter</a>
			</p>
		</fieldset>
	</form>
</body>
</html>