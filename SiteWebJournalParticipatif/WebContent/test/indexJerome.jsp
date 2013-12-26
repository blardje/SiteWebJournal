<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Démonstration de la jsp</title>
<!-- <link rel="stylesheet" href="css/index.css"> -->
</head>
<body>
	<div>
	<form name="nimp" action="CreationPdf" method="post" >
		<p>Identifiant : 
		<input type="text" name="login" value="login"  />
		</p>
		<p>
        Mot de passe : 
        <input type="password" name="pwd" value="pwd" />
        <input type="submit" name="submit" value="Valider" />
        </p>
	</form>
		
	</div>
</body>
</html>