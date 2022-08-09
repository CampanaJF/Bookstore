<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<%@include file="head.jsp"%>
	
<title>Resultados</title>

<body class="orange lighten-4">
	
	<%@include file="header.jsp" %>
	
	<c:if test="${not empty libros}"> 
	             
	   <c:forEach items="${libros}" var="libro"> 
          
               <div class="mb0 pb row section valign-wrapper" >
                    <span class="ps minitexto">${libro.titulo}</span>
                    <span class="ps minitexto">${libro.autor.nombre}</span>
                </div>

	   </c:forEach>
    </c:if>
    
    <c:if test="${not empty autores}"> 
	             
	   <c:forEach items="${autores}" var="autor"> 
          
               <div class="mb0 pb row section valign-wrapper" >
                    <span class="ps minitexto">${autor.apellido}</span>
                    <span class="ps minitexto">${autor.nombre}</span>
                </div>

	   </c:forEach>
    </c:if>
    
    <c:if test="${not empty usuarios}"> 
	             
	   <c:forEach items="${usuarios}" var="usuario"> 
          
               <div class="mb0 pb row section valign-wrapper" >
                    <span class="ps minitexto">${usuario.nombre}</span>
                </div>

	   </c:forEach>
    </c:if>


<%@include file="footer.jsp" %>

</body>
</html>