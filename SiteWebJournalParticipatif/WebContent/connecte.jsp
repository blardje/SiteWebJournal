<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Journal participatif</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/connecte.css">
	<link rel="stylesheet" href="css/enTeteConnecte.css">
</head>

<body>
	<header id='header'> <c:import
		url="/PagePart/enTeteConnecte.jsp" /> 
	</header>

	<article id="realBody">

	<div id="bodyJournal">
		<div id="mesZones">
			<span>Mes zones : </span>
			<select id="mesZoneSelect">
				<option value="">Toutes</option>
				<option value="">Balma</option>
				<option value="">Porspoder</option>
				<option value="">Ajouter...</option>
			</select>
		</div>

		<div id="menu">
			<ul id="onglets">
				<li class="active"><a href="#"> Hyperlocal </a></li>
				<li><a href="#"> Local </a></li>
				<li><a href="#"> Départemental </a></li>
				<li><a href="#"> Régional </a></li>
				<li><a href="#"> National </a></li>
				<li><a href="#"> International </a></li>
			</ul>
		</div> 

		<div id="rightZone">
			<div id="rightTendanceMenu">
				<div class="rightTitle">Tendances</div>
				<span class="separationBleu"></span>
			</div>
	
			<div id="rightAnnonceMenu">
				<div class="rightTitle">L'info en direct</div>
				<span class="separationBleu"></span>
			</div>
	
			<div id="rightEventMenu">
				<div class="rightTitle">Evenements</div>
				<span class="separationBleu"></span>
			</div>
	</div>
	
		<div id="contenuJournal">

		<div id="popularite">
			<select id="populariteSelect">
				<option value="">Trier par popularité</option>
				<option value="">Trier par date</option>
			</select>
		</div>
		
			<div id="contenuName">
				<ul id="ongletsRubrique">
					<li class="activeRubrique"><a href="#">A la une</a></li>
					<li><a href="#">Politique</a></li>
					<li><a href="#">Economie</a></li>
					<li><a href="#">Sport</a></li>
					<li><a href="#">Culture</a></li>
					<li><a href="#">Petites annonces</a></li>
					<li><a href="#">Location/Achat</a></li>
				</ul>
			</div>
			<div class="fluxArticle">

				<div class="categorie">
					<div class="titreCategorie">A la une</div>

					<c:forEach items="${ articles }" var="articles" varStatus="boucle">
						<c:if test="${ articles.getCategorie()  == 'A la une'}">
							<div class="rubrique">
								<div class="logo${ articles.getIdUtilisateur()}"></div>
								<div class="rightDate">
									<div>10h06</div>
									<div>Today</div>
								</div>
								<div class="groupeArticle">
									<div class="titreArticle">${ articles.getTitre() }</div>
									<div class="article">${ articles.getTextArticle() }</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>

				<div class="categorie">
					<div class="titreCategorie">Politique</div>

					<c:forEach items="${ articles }" var="articles" varStatus="boucle">
						<c:if test="${ articles.getCategorie()  == 'Politique'}">
							<div class="rubrique">
								<div class="logo${ articles.getIdUtilisateur()}"></div>
								<div class="rightDate">
									<div>10h06</div>
									<div>Today</div>
								</div>
								<div class="groupeArticle">
									<div class="titreArticle">${ articles.getTitre() }</div>
									<div class="article">${ articles.getTextArticle() }</div>
								</div>
							</div>
						</c:if>
					</c:forEach>

				</div>


				<div class="categorie">
					<div class="titreCategorie">Economie</div>

					<c:forEach items="${ articles }" var="articles" varStatus="boucle">
						<c:if test="${ articles.getCategorie()  == 'Economie'}">
							<div class="rubrique">
								<div class="logo${ articles.getIdUtilisateur()}"></div>
								<div class="rightDate">
									<div>10h06</div>
									<div>Today</div>
								</div>
								<div class="groupeArticle">
									<div class="titreArticle">${ articles.getTitre() }</div>
									<div class="article">${ articles.getTextArticle() }</div>
								</div>
							</div>
						</c:if>
					</c:forEach>

				</div>

				<div class="categorie">
					<div class="titreCategorie">Sport</div>

					<c:forEach items="${ articles }" var="articles" varStatus="boucle">
						<c:if test="${ articles.getCategorie()  == 'Sport'}">
							<div class="rubrique">
								<div class="logo${ articles.getIdUtilisateur()}"></div>
								<div class="rightDate">
									<div>10h06</div>
									<div>Today</div>
								</div>
								<div class="groupeArticle">
									<div class="titreArticle">${ articles.getTitre() }</div>
									<div class="article">${ articles.getTextArticle() }</div>
								</div>
							</div>
						</c:if>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>

	<footer id='footer'> <c:import url="/PagePart/footer.jsp" />
	</footer> 
	
	</article>
	<!--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.js"></script>-->
	<script
		src="https://maps.googleapis.com/maps/api/js?sensor=false&amp;libraries=places"></script>
	<script type="text/javascript">
            function initialize() {
               var input = document.getElementById('localisationInput');
               /* restrict to multiple cities? */
               var options = {
                  types: ['geocode'],
                  componentRestrictions: {country: "fr"}
               };
               var autocomplete = new google.maps.places.Autocomplete(input, options);
            }
            google.maps.event.addDomListener(window, 'load', initialize);
        </script>
</body>
</html>