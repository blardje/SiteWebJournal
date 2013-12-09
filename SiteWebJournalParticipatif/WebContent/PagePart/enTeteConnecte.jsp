<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

 <div id="menuPrinicpal">
     <span id="logoJournal">Votre Journal</span>
     <ul id="ongletsPrincipal">
         <!--<li class="activePrincpal" ><a id="logoHome" href="#"></a></li>-->
         <li class="activePrincpal" ><a href="#">Accueil</a></li>
         <li><a href="#">Mon Journal</a></li>
         <li><a href="#">Mon agenda</a></li>
         <li><a href="#">Mon compte</a></li>
         <li><a href="#">Aide</a></li>
     </ul>
     <div id="recherche">
         <input type="text" name="recherche" id="rechercheInput" value="Recherche" onfocus="if (this.value === 'Recherche') {
                 this.value = '';
                 this.style.color = '#000000';
             }" onblur="if (this.value === '') {
                         this.value = 'Recherche';
                         this.style.color = '#999999';
                     }" />
         <a href="#" id="rechercheIcon" name="rechercheIcon"></a>
     </div>
     <div id="deconnexionBox">
         <a href="#" id="deconnexion" name="Deconnexion"></a>
         <span id="pseudo">Mr. Martin</span>
     </div>
     
 </div>