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
			crossorigin="anonymous" />
			
		<link 
			rel="stylesheet"
			type="text/css"
			href="css/noticia.css" />
			
		<link 
			href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;700&display=swap" 
			rel="stylesheet" />
	</head>
	
	<body>
	
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light layout-cabecalho layout-cabecalho--home">
				<div class="container">
					<h4 class="layout-header--logo">AnimeNews MJV</h4>
					<div class="collapse navbar-collapse">
					
						<form class="form-inline my-2 my-lg-0 offset-sm-2">
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
								<a class="nav-link" href="/noticias">Home <span class="sr-only">(current)</span></a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">Top3Animes</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="https://github.com/EquipeMjv/noticiasMjv" target="blank">GitHub</a>
							</li>
						</ul>
						
						<span class="layout-header--usuario">Usuario: <a href="#">Thiago</a></span>
						
					</div>
				</div>
			
				
			</nav>
		</header>
		
		<div class="container">
			<div class="layout-box">
				<c:forEach var="noticia" items="${noticias.content}">
				
						<div class="card mb-3 layout-box__item" style="max-width: 600px;">
							<div class="row no-gutters">
								<div class="col-md-4">
									<img src="https://picsum.photos/166/300" class="card-img">
								</div>
								<div class="col-md-8">
									<div class="card-body">
										<h5 class="card-title">${noticia.titulo}</h5>
										<p class="card-text">${noticia.descricao}</p>
										<p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
									</div>
								</div>
						    </div>
						</div>
	
				</c:forEach>
				
				<div class="offset-sm-5">
					<nav>
						<ul class="pagination">
							<li class="page-item disabled">
								<a class="page-link" href="#"><span aria-hidden="true">&laquo;</span></a>
							</li>
							<li class="page-item"><a class="page-link" href="?page=0">1</a></li>
							<li class="page-item"><a class="page-link" href="?page=1">2</a></li>
							<li class="page-item"><a class="page-link" href="?page=2">3</a></li>
							<li class="page-item">
								<a class="page-link" href="#"><span aria-hidden="true">&raquo;</span></a>
							</li>
						</ul>
					</nav>
				</div>
				
			</div>
		</div>
		
		<footer>
			<div class="layout-footer">
				<div class="container">
					<p class="text-center">
						Página desenvolvida durante a <mark>DevSchool</mark> e mantida pelo membros 
						<em>Braian, Daniel e Thiago</em> da <strong>AnimeNews MJV</strong> - Out/2020
					</p>
				</div>
			</div>
		</footer>
		
	
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
</html