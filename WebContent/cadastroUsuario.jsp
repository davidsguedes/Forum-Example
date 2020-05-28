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
<title>Game fórum: Novo usuário</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<div class="form-inline">
		<br>
		<h1>GameForum</h1>
		<br>
		</div>
	</nav>
	<h1 class="col-md-6 offset-md-3">Novo usuário</h1>
	<form method="POST" action="cadastroUsuario" class="col-md-6 offset-md-3">
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputNome">Nome</label> <input type="text"
					class="form-control" name="nome" id="nome">
			</div>
			<div class="form-group col-md-6">
				<label for="inputLogin">Login</label> <input type="text"
					class="form-control" name="login" id="login">
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputEmail">Email</label> <input type="email"
					class="form-control" name="email" id="email">
			</div>
			<div class="form-group col-md-6">
				<label for="inputPassword">Password</label> <input type="password"
					class="form-control" name="senha" id="senha">
			</div>
		</div>
		<button type="submit" class="btn btn-primary" id="confirmaCadastro"
			value="confirmaCadastro">Cadastrar</button>
	</form>
	
	<form class="col-md-6 offset-md-3"
		action="login.jsp">
		<button type="submit" class="btn btn-primary" id="insereTopico"
			placeholder="login" value="login">Voltar</button>
	</form>

</body>
</html>

<!-- 	<form method="POST" action="cadastro" >
		Nome  <input type="text" name="nome" id="nome"/>
		<br><br>
		Login  <input type="text" name="login" id="login"/>
		<br><br>
		E-mail  <input type="text" name="email" id="email"/>
		<br><br>
		Senha  <input type="text" name="senha" id="senha"/>
		<input type="submit" id="login" value="Entrar">
	</form> -->