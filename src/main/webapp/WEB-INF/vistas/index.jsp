<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<%@include file="head.jsp"%>

	<title>Home</title>

	<body class="orange lighten-4">
	
	<%@include file="header.jsp" %>
	
	<c:if test="${not empty mensaje}">
    <div class="row center">
        <p class="iconrojo subtitulo col s12">${mensaje}</p> 	
    </div>
    </c:if>
	
		<!--Banner parallax -->
		<div id="index-banner" class="parallax-container">
			<div class="section no-pad-bot">
			  <div class="container">
				<br><br>
				<h1 class="tituloprincipal center orange-text text-darken-3">Shelves</h1>
				<div class="row center">
				  <h5 class="subtitulo col s12">La estanteria del mundo</h5> 	
				</div>

				<div class="row center">
			
					<form action="busqueda">	
						<div class="input-field">
							<span class="material-symbols-outlined prefix">
							</span>
							<input type="text" class="white-text materialize-textarea" name="buscado">
							<button type="submit" id="download-button"
							   class="texto btn-large waves-effect orange darken-3" href="historias">Buscar</button>
						</div>
					</form>  			  
				</div>

				<br><br>
			  </div>
			</div>
			<div class="parallax">
				<img class="" src="img/1884665.jpg" alt="Unsplashed background img 1">
			</div>
		</div>

		<!--Container cards-->
		<div class="container">

			<h5 class="center tituloprincipal">Agregados Ultimamente</h5>
		<!--Cards-->
		<div class="row section">
			
			<div class="col s6 m6 l3">
			  <div class="texto card medium">
				<a href="">
				<div class="card-image">
				  <img src="img/book.jpeg"> <!--300x300-->
				  <span class="card-title">Titulo de libro zero</span>
				</div>
				<div class="card-content">
				  <p class="black-text">I am a very simple card. I am good at containing small bits of information.</p>
				</div>
				</a>
			  </div>
			</div>
		
		</div>

		
		</div>
		
		<!--Container cards-->
		<div class="container">

			<h5 class="center tituloprincipal">Agregados Ultimamente</h5>
		<!--Cards-->
		<div class="row section">
		
		<c:forEach items="${libros}" var="libros">
			
			<div class="col s6 m6 l3">
			  <div class="texto card medium">
				<a href="libro?libroId=${libros.id}">
				<div class="card-image">
				  <img src="<c:url value="/img/${libros.portada}.jpeg"/>"> <%-- 300x300 --%>
				  <span class="black-text card-title">${libros.titulo}</span>
				</div>
				<div class="card-content">
				
				<c:if test="${libros.lenguaje != 'Espanol'}">
				  <img class="icons" src="<c:url value="img/${libros.lenguaje}.svg" />">
				  <p class="black-text">${libros.lenguaje}</p>	
				</c:if>
				
				<c:if test="${libros.lenguaje == 'Espanol'}">
				  <img class="icons" src="<c:url value="img/Espanol.svg" />">
				  <p class="black-text">Espa&#241ol</p>	
				</c:if>
				
				  <p class="black-text">${libros.autor.nombre} ${libros.autor.apellido}</p>
				  
				</div>
				</a>
			  </div>
			</div>
			
			</c:forEach>

		</div>

		<%@include file="footer.jsp" %>
	</body>
	
	
	
</html>