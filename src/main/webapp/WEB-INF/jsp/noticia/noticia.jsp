<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		
		<!-- ANUNCIOS DA PÁGINA -->
		<div class="container">
			<div class="layout-box">
				<c:forEach var="noticia" items="${pagina}">
				
						<div class="card mb-3 layout-box__item">
							<div class="row no-gutters">
								<div class="col-md-4">
									<img src="${noticia.imagem}" class="card-img" />
								</div>
								<div class="col-md-8">
									<div class="card-body">
										
										<div class="close">
											<form action="/clientes/${usuarioLogado.get().id}/animes/${noticia.id}" method="post">
												<button class="btn-outline-secondary" type="submit" style="border-width: 0">
													<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-plus-circle-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
														<path fill-rule="evenodd" d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3v-3z"/>
													</svg>
												</button>
												
												<a class="btn-outline-secondary" href="#" type="button">
													<svg width="0.75em" height="0.75em" viewBox="0 0 16 16" class="bi bi-pencil-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
														<path fill-rule="evenodd" d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
													</svg>
												</a>
											</form>
										</div>
										
										<h5 class="card-title">${noticia.titulo}</h5>
										<p class="card-text">${noticia.descricao}</p>
										<p class="card-text">
											<small class="text-muted">
												Postado: ${noticia.dataCriacao}
												<%-- <fmt:formatDate value="${noticia.dataCriacao}" pattern="dd/MM/yyyy"/> --%>
											</small>
										</p>
									</div>
								</div>
						    </div>
						</div>
	
				</c:forEach>
			</div>	
		</div
				
		<!-- PAGINAÇÃO -->
<%-- 		<div class=container>
			<nav>
				<ul class="pagination justify-content-center">
					<!-- BOTÃO PÁGINA ANTERIOR-->
					<c:if test="${not pagina.first}">
						<li class="page-item">
							<a class="page-link" href="?page=${pagina.number-1}"><span aria-hidden="true">&laquo;</span></a>
						</li>
					</c:if>
					<c:if test="${pagina.first}">
						<li class="page-item disabled">
							<a class="page-link" href="#"><span aria-hidden="true">&laquo;</span></a>
						</li>
					</c:if>

					<!-- BOTÕES PÁGINAS -->
					<c:forEach var="i" begin="1" end="${pagina.totalPages}" step="1">
						<c:if test="${pagina.number + 1 == i}">
							<li class="page-item active"><a class="page-link" href="?page=${i-1}">${i}</a></li>
						</c:if>
						
						<c:if test="${pagina.number + 1 != i}">
							<li class="page-item"><a class="page-link" href="?page=${i-1}">${i}</a></li>
						</c:if>
					</c:forEach>
					
					
					<!-- BOTÃO PROXIMA PÁGINA -->
						<c:if test="${not pagina.last}">
						<li class="page-item">
							<a class="page-link" href="?page=${pagina.number+1}"><span aria-hidden="true">&raquo;</span></a>
						</li>
					</c:if>
					<c:if test="${pagina.last}">
						<li class="page-item disabled">
							<a class="page-link" href="#"><span aria-hidden="true">&raquo;</span></a>
						</li>
					</c:if>
				</ul>
			</nav>
		</div> --%>
		
		<!-- RODAPÉ PÁGINA -->
		<footer class="layout-footer">
			<div class="container">
				<p class="text-center">
					Página desenvolvida durante a <mark>DevSchool</mark> e mantida pelo membros 
					<em>Braian, Daniel e Thiago</em> da <strong>AnimeNews MJV</strong> - Out/2020
				</p>
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
</html>