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

	
		<div class = "container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">

					
				<form:form action="validar-login" method="POST" modelAttribute="datosUsuario">
	            <h3 class="form-signin-heading text-white text-center m-2">Inicicar sesion</h3>
	            <hr class="colorgraph">
	            <br>
	
	            
	            <label for="email" class="text-white mb-1">Email</label>
	            <form:input path="email" id="email" type="email"  placeholder="Ingrese el mail"/>
	            
	            <label for="clave" class="text-white mb-1">Password</label>
	            <form:input path="password" type="password" id="password" 
	                        placeholder="Ingrese su clave"/>
	
	          
	            <button class="btn btn-lg btn-primary btn-block m-4" Type="Submit"/>Ingresar</button>
        		</form:form>
				
				<a href="registrar-usuario"	>Registrarme</a>
				
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>
		        
			</div>
		</div>
		
		<%@include file="footer.jsp" %>
	</body>
</html>
