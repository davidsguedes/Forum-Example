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
<title>Game fórum: Ranking</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<div class="form-inline">
			<h1 class="navbar-brand" id="usuarioLogado">User: <%=session.getAttribute("login")%></h1><form method="GET" action="Logout"><button type="submit" class="btn btn-primary" id="logout" value="Encerrar sessão">Sair</button></form>
		</div>
	</nav>
	<h1 class="col-md-6 offset-md-3">Ranking</h1>

	<div class="col-md-6 offset-md-3">
		<table class="table table-hover" id="ranking">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Colocação</th>
					<th scope="col">Nome</th>
					<th scope="col">Login</th>
					<th scope="col">Pontos</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${lista}">
					<tr>
						<th scope="row" var="colocacao"=0>${colocacao = colocacao +1}º</th>
						<td><c:out value="${item.nome}" /></td>
						<td><c:out value="${item.login}" /></td>
						<td><c:out value="${item.pontos}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<form method="POST" class="col-md-6 offset-md-3"
		action="ListaTopicosServlet">
		<button type="submit" class="btn btn-primary" id="topicos"
			value="Tópicos">Tópicos</button>
	</form>


</body>
</html>