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
<title>Game fórum: Tópicos</title>
</head>
<body>

	<nav class="navbar navbar-light bg-light">
		<div class="form-inline">
			<h1 class="navbar-brand" id="usuarioLogado">User: <%=session.getAttribute("login")%></h1><form method="GET" action="Logout"><button type="submit" class="btn btn-primary" id="logout" value="Encerrar sessão">Sair</button></form>
		</div>
	</nav>
	<h1 class="col-md-6 offset-md-3">Tópicos</h1>

	<div class="col-md-6 offset-md-3">
		<table class="table table-hover" id="topicos">
			<thead class="thead-dark">
				<tr>
					<th scope="col" id="ordem">#</th>
					<th scope="col" id="titulo">Titulo</th>
					<th scope="col" "id="criadoPor">Criado por</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${lista}">
					<tr>
						<th scope="row" var="ordem"=0>${ordem = ordem +1}</th>
						<td><c:set var="titulo" value="${item.titulo}" /> <a
							href="${pageContext.request.contextPath}/ListaTopicoServlet?action=recuperarTopico&id_topico=${item.id_topico}" />
							<c:out value="${item.titulo}" /> </a></td>
						<td><c:out value="${item.login}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<form method="POST" class="col-md-6 offset-md-3"
		action="rankingServlet">
		<button type="submit" class="btn btn-primary" id="ranking"
			value="Ver ranking">Ranking</button>
	</form>
	<form method="POST" class="col-md-6 offset-md-3"
		action="insereTopico.jsp">
		<button type="submit" class="btn btn-primary" id="insereTopico"
			placeholder="Inserir tópico" value="Inserir tópico">Inserir
			tópico</button>
	</form>


</body>
</html>