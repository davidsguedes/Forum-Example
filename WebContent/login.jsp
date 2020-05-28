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
<title>Game fórum: Login</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<div class="form-inline">
		<br>
		<h1>GameForum</h1>
		<br>
		</div>
	</nav>
	<h1 class="col-md-6 offset-md-3" id="cabecalhoEntrar">Entrar</h1>
	<br>
	<form method="POST" class="col-md-6 offset-md-3" action="login">
		<div class="form-group">
			<label for="exampleInputEmail1">Login</label> <input type="text"
				class="form-control" aria-describedby="emailHelp" name="login"
				id="login">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Senha</label> <input
				type="password" class="form-control" name="senha" id="senha">
		</div>
		<button type="submit" class="btn btn-primary" id="entrar"
			value="Entrar">Entrar</button>
	</form>
</body>
</html>