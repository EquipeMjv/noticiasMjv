<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link 
			rel="stylesheet" 
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" 
			integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" 
			crossorigin="anonymous" />
			
		<link 
			rel="stylesheet"
			type="text/css"
			href="css/login.css" />
			
		<link 
			href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;700&display=swap" 
			rel="stylesheet" />
	</head>
	
	<body>
	
		<div class="container">
			<div class="layout-login">
				<h1 class="text-center">AnimeNews MJV</h1>
				
				<c:if test="${not empty mensagem}">
					<div class="alert alert-danger" role="alert">
						<c:out value="${mensagem}" />
					</div>
				</c:if>
				
				<form action="/login" method="post">
					<div class="form-group">
						<label for="txtUsuario">Usuario</label>
						<input type="text" name="usuario" class="form-control" id="txtUsuario" placeholder="Digite seu usuario...">
					</div>
					<div class="form-group">
						<label for="txtSenha">Senha</label>
						<input type="password" name="senha" class="form-control" id="txtSenha" placeholder="Digite sua senha...">
					</div>
					<button type="submit" class="btn btn-primary">Entrar</button>
				</form>
			</div>
		</div>
		
	
		<script 
			src="https://code.jquery.com/jquery-3.5.1.slim.min.js" 
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" 
			crossorigin="anonymous">
		</script>
		<script 
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" 
			integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" 
			crossorigin="anonymous">
		</script>
	</body>
</html>