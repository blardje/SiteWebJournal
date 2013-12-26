<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

 <div id="menuPrinicpal">
     <span id="logoJournal">Votre Journal</span>
     <div id="ongletsPrincipal">
         <div class="li activePrincpal" ><a href="./FluxArticles">Accueil</a></div>
	     <div id="recherche">
	        <input type="text" name="recherche" id="rechercheInput" value="Recherche" placeholder="Recherche"  />
<!-- 	        <a href="#" id="rechercheIcon" name="rechercheIcon"></a> -->
	     </div>
         <div class="li"><a href="./mapRecherche.jsp">Map</a></div>
         <div class="li"><a href="./depotArticle.jsp">Poster</a></div>
         <div class="li"><a href="#">Mon compte</a></div>
         <div class="li"><a href="#">Aide</a></div>
	     <div id="deconnexionBox">
	        <a href="#" id="deconnexion" name="Deconnexion"></a>
	        <span id="pseudo">Mr. Martin</span>
	     </div>
     </div>
     
 </div>