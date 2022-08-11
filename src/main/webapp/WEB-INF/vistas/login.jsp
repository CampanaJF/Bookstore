<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<%@include file="head.jsp"%>

	<title>Login</title>

	<body class="orange lighten-4">
	
	<%@include file="header.jsp" %>

		<div class="container">

			<a id="logo-container" href="home" class="brand-logo">
			<h1 class="tituloprincipal center orange-text text-darken-3">Shelves</h1></a>
			<div class="row center">
				<h5 class="subtitulo col s12">La estanteria del mundo</h5> 	
			</div>
	
		<div class="row">
		<div class="col s6">
	
		<form:form action="validar-login" method="POST" modelAttribute="datosUsuario">
	
		<div class="row center">
			<p class="subtitulo col s12">Ingrese sus datos para iniciar sesion</p> 	
	   </div>
	
	  <div class="row">
  
		<div class="input-field">
		  <input path="email" name="email" id="email"
			type="text" class="validate" >
		  <label for="email">Email</label>
		  <span class="helper-text" 
		   data-error=""
		   data-success=""></span>
		</div>
	  </div>
	
	  <div class="row">
		<div class="input-field">
		  <input path="password" type="password"  name="password" id="password" type="password">
		  <label for="password">Contrase&#241a</label>
		  <span class="helper-text"
		   data-error=""
		   data-success=""></span>
		</div>  
	  </div>
	
		<c:if test="${not empty mensaje}">
		<div class="row center">
			<p class="iconrojo subtitulo col s12">${mensaje}</p> 	
		</div>
		</c:if>
	
	  <div class="row center">
		<button type="submit" id="download-button"
		class="texto btn-large waves-effect orange darken-3">Login</button>
	  </div>
	
		</form:form>
		</div>
	
		<div class="col s6">
			<img class="z-depth-5 EnterImg" src="img/homeimg.jpg">
		</div>
	
	</div>
	
	</div>  
		
		<%@include file="footer.jsp" %>
	</body>
</html>
