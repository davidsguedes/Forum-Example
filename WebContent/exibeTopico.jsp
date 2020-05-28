<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game fórum: Tópico - Detalhe</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<div class="form-inline">
			<h1 class="navbar-brand" id="usuarioLogado">User: <%=session.getAttribute("login")%></h1><form method="GET" action="Logout"><button type="submit" class="btn btn-primary" id="logout" value="Encerrar sessão">Sair</button></form>
		</div>
	</nav>
	<h1 class="col-md-6 offset-md-3">Detalhe - Tópico</h1>

	<div class="col-md-6 offset-md-3">
		<table class="table table-hover" id="topico">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Titulo</th>
					<th scope="col">Criado por</th>
					<th scope="col">Conteúdo</th>
				</tr>
			</thead>
			<tbody>
				<tr var="topico" item="${topico}">
					<td value="titulo" />${topico.titulo}</td>
					<td value="login" />${topico.login}</td>
					<td value="conteudo" />${topico.conteudo}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<br>
	<br>
	<br>

	<div class="col-md-6 offset-md-3">
		<table class="table table-hover" id="comentarios" border="1">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Criado por</th>
					<th scope="col">Comentário</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${lista}">
					<tr>
						<td><c:out value="${item.login}" /></td>
						<td><c:out value="${item.comentario}" /></td>
					</tr>
				</c:forEach>
			<tbody>
		</table>
	</div>








	<br>
	<br>
	<br>
	<form method="POST" class="col-md-6 offset-md-3"
		action="cadastroComentario">
		<div class="form-group">
			<label for="Comentario">Comentário</label>
			<textarea class="form-control" name="textoComentario"
				id="textoComentario" rows="6"></textarea>
		</div>
		<button type="submit" class="btn btn-primary" id="insereComentario"
			value="Inserir" />
		Cadastrar
		</button>
	</form>

	<form method="POST" class="col-md-6 offset-md-3"
		action="ListaTopicosServlet">
		<div class="form-group">
			<button type="submit" class="btn btn-primary" id="topicos"
				value="Tópicos">Tópicos</button>
		</div>
	</form>
</body>
</html>