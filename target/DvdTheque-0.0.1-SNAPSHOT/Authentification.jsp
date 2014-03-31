<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %> <!-- cette bib est decrite ds un fichier(*.tld) sur glassfisg en format xml -->
<!DOCTYPE HTML>
<html lang ="fr">
<head>   
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Se connecter</title>
<c:url var = "jQuery"    value="/_js/libs/jquery-1.10.2.min.js"/>
<c:url var = "js"        value="/_js/valider.js"/>
<c:url var = "normalize" value="/_css/normalize.css"/>
<c:url var = "style"     value="/_css/styles.css"/>
<c:url var = "urlListe"    value="/dvd/liste"/>
<c:url var = "urlCompte"    value="/Compte"/>
	
	<link rel="stylesheet" href="${normalize}" type="text/css" media="screen" />
	<link rel="stylesheet" href="${style}"     type="text/css" media="screen" />
</head>
<body>
<p id="succes">Il y a actuellement  :${nbvisiteurs} utilisateur(s) connect�(s)</p>
	<form method="post" action="${urlListe}" id="frmConnection">
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
				<input type="submit" name="submit" value="Connecter" id="submit"/>
				<input type="reset"  name="reset"  value="R�initialiser" id="reset"/>
			</p>
			<p id="message">${msg}</p>
			<p>
				<a target="" href="${urlCompte}">Cr�er un compte</a>
			</p>
		</fieldset>
	</form>
</body>
</html>