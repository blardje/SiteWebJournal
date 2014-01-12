<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <div id="menuPrinicpal">
     <span id="logoJournal">Votre Journal</span>
     <div id="ongletsPrincipal">
         <div class="li activePrincpal" ><a href="./FluxArticles">Accueil</a></div>
	     <div id="recherche">
	        <input type="text" name="recherche" id="rechercheInput" value="Recherche" placeholder="Recherche"  />
<!-- 	        <a href="#" id="rechercheIcon" name="rechercheIcon"></a> -->
	     </div>
         <div class="li"><a href="./MapRechercheServlet">Map</a></div>
         <div class="li"><a href="./restreint/depotArticle.jsp">Poster</a></div>
<!--          <div class="li"><a href="./AccessDepotArticle">Poster</a></div> -->
         <div class="li"><a href="#">Mon compte</a></div>
         <div class="li"><a href="#">Aide</a></div>
	     <div id="connexionBox">
    		<form action="<c:url value="/ConnexionUser"/>" method="post">
				<input type="text" class="input" id="emailUserInscrit" placeholder="Email" name="emailInscrit" value="" size="17" maxlength="30"/>
				<input type="password" class="input" id="pwdUserInscrit" placeholder="Mot de passe" name="pwdInscrit" value="" size="17" maxlength="30"/>
               	<input type="submit" value="Connexion"  />
           	</form>
	     </div>
     </div>
     
 </div>