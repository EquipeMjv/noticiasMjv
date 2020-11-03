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
				
		<!-- PAGINAÇÃO -->
 		<div class=container>
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