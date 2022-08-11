<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="head.jsp"%>


	<title>Registrarse</title>


	<body class="orange lighten-4">

<div class="container">

		<a id="logo-container" href="home" class="brand-logo">
		<h1 class="tituloprincipal center orange-text text-darken-3">Shelves</h1></a>
        
        <div class="row center">
            <h5 class="subtitulo col s12">La estanteria del mundo</h5> 	
        </div>

    <div class="row">
    <div class="col s6">

    <form:form action="procesarRegistro" method="POST" modelAttribute="datosUsuario">

    <div class="row center">
        <h5 class="subtitulo col s12">Ingresa tus datos y registrate</h5> 	
   </div>

  <div class="row">
    <div class="input-field col s6">
      <input id="name" path="name" name="nombre" id="name"
        type="text" class="validate">
      <label for="name">Nombre</label>
      <span class="helper-text" data-error=""
      data-success="">Almenos 4 Caracteres</span>
    </div>
  
    <div class="input-field col s6">
      <input path="email" name="email" id="email"
       required pattern="/^[0-9a-zA-Z._.-]+\@[0-9a-zA-Z._.-]+\.[0-9a-zA-Z]+$/"
        type="email" class="validate">
      <label for="email">Email</label>
      <span class="helper-text" 
       data-error="Formato de Email no valido"
       data-success="Direccion valida">Debe ser una direccion de correo valida</span>
    </div>
  </div>

  <div class="row">
    <div class="input-field col s6">
      <input path="password" type="password"  name="password" id="password"
       required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{12,}" type="password" class="validate">
      <label for="password">Contrase&#241a</label>
      <span class="helper-text"
       data-error="Contrase&#241a insegura"
       data-success="Contrase&#241a segura">Debe tener mas de 12 caracteres, una mayuscula y un numero</span>
    </div>
  
    <div class="input-field col s6">
      <input path="passwordRe" type="password"  name="passwordRe" id="passwordRe"
       required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{12,}" type="password" class="validate">
      <label for="passwordRe">Repetir Contrase&#241a</label>
      <span class="helper-text" data-error="Contrase&#241a diferente" 
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
    class="texto btn-large waves-effect orange darken-3">Registrarme</button>
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