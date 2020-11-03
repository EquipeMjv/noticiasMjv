<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
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
		
		<!-- BARRA DE MENUS DA PÁGINA -->
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light layout-cabecalho layout-cabecalho--home">
				
				<div class="container">
					<h4 class="layout-header--logo">AnimeNews MJV</h4>
					<div class="collapse navbar-collapse">
					
						<c:if test="${usuarioLogado.get().usuario == 'admin'}">
							<form class="form-inline my-2 my-lg-0 offset-sm-1">
						</c:if>
						<c:if test="${usuarioLogado.get().usuario != 'admin'}">
							<form class="form-inline my-2 my-lg-0 offset-sm-2">
						</c:if>
							<input class="form-control mr-sm-2" type="search" placeholder="Pesquisar">
							<button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">
								<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-search" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
									<path fill-rule="evenodd" d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z"/>
									<path fill-rule="evenodd" d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
								</svg>
							</button>
						</form>
						
						<ul class="navbar-nav ml-md-auto">
 							<li class="nav-item active">
								<a class="nav-link" href="/noticias">Home</span></a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">Top3Animes</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="https://github.com/EquipeMjv/noticiasMjv" target="blank">GitHub</a>
							</li>
							
							<c:if test="${usuarioLogado.get().usuario == 'admin'}">
								<li class="nav-item">
									<a class="nav-link layout-novaNoticia--botao" href="/noticias/nova">Nova noticia</a>
								</li>
							</c:if>
						</ul>
						
						<c:if test="${usuarioLogado.get().usuario == 'admin'}">
							<div class="dropdown layout-header--usuario">
								<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
								  ${usuarioLogado.get().nome}
								</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="#">Perfil</a>
									<a class="dropdown-item" href="/clientes/${usuarioLogado.get().id}/animes/">Meus Animes</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="/logout">Sair</a>
								</div>
							</div>
						</c:if>
						<c:if test="${usuarioLogado.get().usuario != 'admin'}">
							<div class="dropdown layout-header--usuario">
								<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
								  ${usuarioLogado.get().usuario}
								</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="#">Perfil</a>
									<a class="dropdown-item" href="/clientes/${usuarioLogado.get().id}/animes/">Meus Animes</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="/logout">Sair</a>
								</div>
							</div>
						</c:if>
						
					</div>
				</div>
			
			</nav>
		</header>
		
	
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