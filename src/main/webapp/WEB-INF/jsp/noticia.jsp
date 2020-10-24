<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Noticias</title>
		<link 
			rel="stylesheet" 
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" 
			integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" 
			crossorigin="anonymous">
			
		<link 
			rel="stylesheet"
			type="text/css"
			href="css/noticia.css" />	
	</head>
	
	<body>
	
		<div class="container">
			<h1>Usuario: Thiago</h1>		
		</div>
		
		<div class="container">
			
			<c:forEach var="noticia" items="${noticias}">
			
				<div class="row justify-content-center box">
					<div class="col-md-3">
						<img src="https://picsum.photos/159/236" class="card-img" alt="...">
					</div>
					
					<div class="col-md-4">
						<div class="card-body">
							<h5 class="card-title">${noticia.titulo}</h5>
							
							<p class="card-text">${noticia.descricao}</p>
							
							<p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
						</div>
					</div>
				</div>

			</c:forEach>
								
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