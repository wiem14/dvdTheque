<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %> <!-- cette bib est decrite ds un fichier(*.tld) sur glassfisg en format xml -->
<html lang="fr">
<script id="tinyhippos-injected">if (window.top.ripple) { window.top.ripple("bootstrap").inject(window, document); }</script><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

    <title>Page d'authentification</title>
	<c:url var = "jQuery"    value="/_js/libs/jquery-1.10.2.min.js"/>
	<c:url var = "bootstjs"    value="/_js/bootstrap.min.js"/>
	
	<c:url var = "normalize" value="/_css/normalize.css"/>
	<c:url var = "boots"     value="/_css/bootstrap.min.css"/>
	<c:url var = "signin"     value="/_css/signin.css"/>
	
	<c:url var = "urlListe"    value="/dvd/liste"/>
	<c:url var = "urlCompte"    value="/Compte"/>
	
	<link rel="stylesheet" href="${normalize}"  />
	<link rel="stylesheet" href="${boots}" />
	<link rel="stylesheet" href="${signin}" />
   
  </head>

  <body>

    <div class="container">
		<p id="succes">Il y a actuellement  :${nbvisiteurs} utilisateur(s) connecté(s)</p>
      	<form class="form-signin" role="form" method="post" action="${urlListe}" id="frmConnection">
        	<h2 class="form-signin-heading">Connectez-vous</h2>
        	<input type="text" class="form-control" name="login" placeholder="Login" id="login" autofocus required ="" value ="${login}"/>${erreur["login"] }
        	<input type="password" class="form-control" placeholder="Mot de passe" required=""  id="mdp" name="mdp" value ="${mdp}"/>${erreur["mdp"] }
        	<label class="checkbox">
          	<input type="checkbox" value="remember-me"> Se souvenir de moi
        	</label>
        	<button class="btn btn-lg btn-primary btn-block" type="submit" name="submit" id="submit">Connecter</button>
      <p id="message">${msg}</p>
			<p>
				<a target="" href="${urlCompte}">Créer un compte</a>
			</p>
      </form>
		
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  

<div id="cacaowebchromeextension"></div>
<script type="text/javascript">var Cacaoweb = { callbackIsRunning: function () { var cacaodiv = document.createElement("div"); cacaodiv.id = "cacaorunning"; document.body.appendChild(cacaodiv); } };</script>
<script id="isrunning" src="http://127.0.0.1:4001/isrunning" type="text/javascript"></script>
	<script src="${jQuery}"></script>
    <script src="${bootstjs}"></script>
</body>
</html>
<!--<!DOCTYPE HTML>
<html lang ="fr">
<head>   

<body>
<p id="succes">Il y a actuellement  :${nbvisiteurs} utilisateur(s) connecté(s)</p>
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
				<input type="reset"  name="reset"  value="Réinitialiser" id="reset"/>
			</p>
			<p id="message">${msg}</p>
			<p>
				<a target="" href="${urlCompte}">Créer un compte</a>
			</p>
		</fieldset>
	</form>
</body>
</html> -->