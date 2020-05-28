<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game fórum</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<div class="form-inline">
		<br>
		<h1>GameForum</h1>
		<br>
		</div>
	</nav>
	<h1 class="col-md-6 offset-md-3">Sessão inválida</h1>
	<h1 class="col-md-6 offset-md-3">Será necessário realizar novo login</h1>
	<form method="POST" action="login.jsp" class="col-md-6 offset-md-3">
		<button type="submit" class="btn btn-primary" id="novoLogin" value="Login">Login</button>
	</form>
</body>
</html>