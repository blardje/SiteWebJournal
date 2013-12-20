<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Journal local participatif</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="css/accueil.css">
	</head>

    <body>
    
    <article>
	    <div id="partA">
	    
	    </div>
	    
	    <div id="partB">
	    
		    <div id="positionConnectionBox">
	        	<div id="connectionBox">
		    		<form action="<c:url value="/ConnexionUser"/>" method="post">
						<input type="text" class="input" id="emailUserInscrit" placeholder="Email" name="emailInscrit" value="" size="30" maxlength="30"/>
						<br />
						
						<input type="password" class="input" id="pwdUserInscrit" placeholder="Mot de passe" name="pwdInscrit" value="" size="30" maxlength="30"/>
						<br />
						
	<%--                 <p class="info">${ form.resultat }</p> --%>
	                	<input type="submit" value="Se connecter"  />
	            	</form>
				</div>
		    </div>
		    
	        <div id="positionInscriptionBox">
	            <div id="inscriptionBox">
	            	<form action="<c:url value="/InscriptionUser" />" method="post" enctype="multipart/form-data">
						<input type="text" class="input" id="nomUser" placeholder="Nom" name="nomUser" value="" size="30" maxlength="30" />
						<br />
						
						<input type="text" class="input" id="emailUser" placeholder="Email" name="emailUser" value="" size="30" maxlength="60" />
						<br />
						
						<input type="password" class="input" id="password" name="password" placeholder="Mot de passe" value="" size="30" maxlength="30" />
						<br />
						
<%-- 	                	<p class="info">${ form.resultat }</p> --%>
	                	<input type="submit" value="S'inscrire à ce journal"  />
	            	</form>
				</div>
	        </div>
	    </div>
    </article>
    
	<footer id='footer'> <c:import url="/PagePart/footer.jsp" />
	
	</footer> 
	
    </body>
</html>