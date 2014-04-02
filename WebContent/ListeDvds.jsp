<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- cette bib est decrite ds un fichier(*.tld) sur glassfisg en format xml -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Liste dvds</title>
	<c:url var = "jQuery"    value="/_js/libs/jquery-1.10.2.min.js"/>
	<c:url var = "bootstjs"    value="/_js/bootstrap.min.js"/>
	
	<c:url var = "normalize" value="/_css/normalize.css"/>
	<c:url var = "boots"     value="/_css/bootstrap.min.css"/>
	<c:url var = "bord"     value="/_css/dashboard.css"/>
	<c:url var = "starter"     value="/_css/starter-template.css"/>


	<c:url var="urlAdd" value="/dvd/add" />
	<link rel="stylesheet" href="${bord}" >
	<link rel="stylesheet" href="${normalize}"  />
	<link rel="stylesheet" href="${boots}" />
	<link href="${starter}" rel="stylesheet">
	
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">DvdTheque</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
     <div class="container">
	<p id="succes">Il y a actuellement  :${nbvisiteurs} utilisateur(s) connecté(s)</p>
	<p id="succes">${succes}</p>
	<h2 class="sub-header">Liste des DVDs</h2>
	
	<div class="table-responsive">
            <table class="table table-striped">
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
   </div>
	

	<p>
		<a target="" href="${urlAdd}">Retour au formulaire</a>
	</p>
	 </div><!-- /.container -->
</body>
<script src="${jQuery}"></script>
    <script src="${bootstjs}"></script>
</html>