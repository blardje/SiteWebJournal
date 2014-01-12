<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Dépot d'un article</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="./css/depotArticle.css">
		<link rel="stylesheet" href="./css/enTete.css">
	</head>

<body>
	<header id='header'> <c:import
		url="/WEB-INF/PagePart/enTeteConnecte.jsp" /> 
	</header>

    <article id="realBody">
    	<div id="contenu">
	       	<div id="depotArticleBox">
	    		<form action="<c:url value="/DepotArticle"/>" method="post" >
	    		
					<input type="text" class="input" id="localisation" placeholder="Localisation" name="localisation" value="" size="30" maxlength="30"/>
					<br />
					
					<input type="text" class="input" id="categorie" placeholder="Catégorie" name="categorie" value="" size="30" maxlength="30"/>
					<br />
					
					<input type="text" class="input" id="titre" placeholder="Titre" name="titre" value="" size="60" maxlength="60"/>
					<br />
					
					<textarea id="textArticle" name="textArticle" placeholder="Contenu de l'article" rows="5"></textarea>
					<br />
					
	<%--                 <p class="info">${ form.resultat }</p> --%>
	               	<input type="submit" value="Déposer l'article"  />
	               	
	           	</form>
			</div>
    	</div>
    	
		<footer id='footer'> 
			<c:import url="/WEB-INF/PagePart/footer.jsp" />
		</footer> 
	
    </article>
	
</body>
</html>