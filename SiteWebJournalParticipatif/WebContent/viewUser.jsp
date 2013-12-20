<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" /> 
        <title>Affichage d'un utilisateur</title>
    </head>
    <body>
        <div id="corps">
            <p class="info">${ message }</p>
        <c:if test="${ !erreur }"> 
     
                <p>Nom : <c:out value="${ user.getFyName() }"/></p>
                <p>Prénom : <c:out value="${ user.getFtName() }"/></p>
                <P>Adresse : <c:out value="${ user.getAddress() }"/></P> 
                <P>Numéro de téléphone : <c:out value="${ user.getTelephone() }"/></P>
                <P>Email : <c:out value="${ user.getEmail() }"/></P> 
                <p>Image : <c:out value="${ user.image }"/></p>
            </c:if>
        </div>
    </body>
</html>