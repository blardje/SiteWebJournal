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
		<link rel="stylesheet" href="css/enTeteConnecte.css">
	</head>

<body onload="initialize();">
	<header id='header'> <c:import
		url="/PagePart/enTeteConnecte.jsp" /> 
	</header>

    <article id="realBody">
    	<div id="contenu">
	       	<div id="rechercheBox">
	       		<div id="information">
		       		<span id="lieu">lieu</span></br>
		       		<span id="latitude">latitude</span></br>
		       		<span id="longitude">longitude</span></br>
		       		<span id="rayon">rayon</span></br>
	       		</div>
		       	<div id="mapBox">
	            	<div id="mapCanvas"></div>
				</div>
			</div>
		</div>
	    
		<footer id='footer'> 
			<c:import url="/PagePart/footer.jsp" />
		</footer> 
		
    </article>
	
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.js"></script>
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?v=3.exp&amp;sensor=false&amp;libraries=drawing"></script>
	<script type="text/javascript" src="./js/mapRecherche.js"></script>
</body>
</html>