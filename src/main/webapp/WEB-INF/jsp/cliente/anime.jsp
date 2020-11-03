<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Meus animes</title>
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
			href="/css/anime.css" />
	</head>
	
	<body>
	
		<c:import url="../layout/header.jsp"></c:import>
		
		<!-- TABELA DE LISTAGEM DE ANIMES -->
		<div class="container">
			
			<h1 class="text-center layout-tabela__titulo">Meus animes</h1>
		
			<div>
				
				<table class="table table-dark">
					<thead>
						<tr>
							<th scope="col">Código</th>
							<th scope="col">Titulo</th>
							<th scope="col">Ações</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach var="anime" items="${animes}">
							<tr>
  								<td style="padding-left: 35px">${anime.noticiaId}</td>
								<td>${anime.titulo}</td>
								<td>
									<a href="#"><span class="badge badge-danger">Excluir</span></a>
								</td>
							</tr>
						</c:forEach>
						
						<c:if test="${animes.size() == 0}">
							<tr>
								<td colspan="3" class="text-center">
									Não foi encontrado nenhum anime cadastrado para esse usuário
								</td>
							</tr>
						</c:if>
					</tbody>
					
				</table>
	
			</div>	
		</div>

		<c:import url="../layout/footer.jsp"></c:import>	
	
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