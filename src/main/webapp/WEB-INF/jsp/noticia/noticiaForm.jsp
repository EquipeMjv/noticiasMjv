<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Nova Noticia</title>
		<link 
			rel="stylesheet" 
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" 
			integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" 
			crossorigin="anonymous" />
			
		<link 
			href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;700&display=swap" 
			rel="stylesheet" />
			
		<link 
			rel="stylesheet"
			type="text/css"
			href="/css/noticia.css" />
	</head>
	
	<body>
				
		<div class="container">
			<div class="layout-box layout-box__item">
			
				<h1 class="text-center layout-box__titulo">Criar nova noticia</h1>
			
				<form action="/noticias/nova" method="post">
					<div class="form-group">
						<label for="txtTitulo">Titulo</label>
						<input 
							type="text" 
							class="form-control" 
							id="txtTitulo" 
							name="titulo" 
							placeholder="Insira o titulo da noticia..." />
					</div>
					
					<div class="form-group">
						<label for="txtDescricao">Descricao</label>
						<textarea
							type="text" 
							class="form-control" 
							id="txtDescricao" 
							name="descricao"
							cols="300"
							rows="5"
							placeholder="Insira a descrição da noticia..."></textarea>
					</div>
					
					<div class="form-group">
						<label for="txtImagem">Imagem</label>
						<input 
							type="text" 
							class="form-control" 
							id="txtImagem" 
							name="imagem" 
							placeholder="Insira a url da imagem da notícia..." />
					</div>

					<div class="text-center">
						<button type="submit" class="btn btn-primary">Criar noticia</button>
						<a type="submit" class="btn btn-danger" href="/noticias">Cancelar</a>
					</div>
					
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