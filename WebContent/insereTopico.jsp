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
<title>Game fórum: Tópico - Novo</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<div class="form-inline">
			<h1 class="navbar-brand" id="usuarioLogado">User: <%=session.getAttribute("login")%></h1><form method="GET" action="Logout"><button type="submit" class="btn btn-primary" id="logout" value="Encerrar sessão">Sair</button></form>
		</div>
	</nav>
	<h1 class="col-md-6 offset-md-3">Novo tópico</h1>

	<form method="POST" class="col-md-6 offset-md-3"
		action="cadastroTopico">
		<div class="form-group">
			<label for="titulo">Titulo</label> <input type="text"
				class="form-control" name="tituloTopico" id="tituloTopico">
		</div>
		<div class="form-group">
			<label for="texto">Texto</label>
			<textarea class="form-control" name="textoTopico" id="textoTopico"
				rows="6"></textarea>
		</div>
		<button type="submit" class="btn btn-primary" id="enviarTopico"
			value="Cadastrar tópico">Cadastrar tópico</button>
	</form>
</body>
</html>