<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Rechercher une zone gépgraphique</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="css/mapRecherche.css">
		<link rel="stylesheet" href="css/enTete.css">
	</head>

<body onload="initialize();">
	<header id='header'> 
		<c:if test="${ sessionScope.sessionUser != null}">
			<c:import url="./PagePart/enTeteConnecte.jsp" /> 
		</c:if> 
		<c:if test="${ sessionScope.sessionUser == null}">
			<c:import url="./PagePart/enTeteNonConnecte.jsp" /> 
		</c:if>
	</header>

    <article id="realBody">
    	<div id="contenu">
	       	<div id="rechercheBox">
	       		<div id="title"> Sélectionner une zone géographique</div>
	       		<div id="information">
			       		
		    		<form action="<c:url value="/ConnexionUser"/>" method="post">
						<input type="text" class="input" id="adresseCentre" placeholder="Adresse du centre du cerlce" name="adresseCentre" value="" size="45" maxlength="30"/>
		       			</br></br>
		       			<div id="slider">
		       				<div id="textSlider">
		       					<span>Rayon : </span>
		       					<output id="rangevalue">250</output>
		       					<span>Km</span>
		       				</div>
                    		<input type="range" name="rayonCercle" id="rayonCercle" value="250" min="0" max="500" onchange="rangevalue.value=value"/></br>
                    	</div>
		           	
		           		</br>
		       			<span class="hide" id="latitude">latitude</span></br>
		       			<span class="hide" id="longitude">longitude</span></br>
                    	<input type="submit" id="submitButtonRecherche" value="Rechercher les articles"  />
		           	</form>
	       		</div>
		       	<div id="mapBox">
	            	<div id="mapCanvas"></div>
				</div>
			</div>
		</div>
	    
		<footer id='footer'> 
			<c:import url="./PagePart/footer.jsp" />
		</footer> 
		
    </article>
	
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.js"></script>
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?v=3.exp&amp;sensor=false&amp;libraries=drawing"></script>
	<script type="text/javascript" src="./js/mapRecherche.js"></script>
</body>
</html>