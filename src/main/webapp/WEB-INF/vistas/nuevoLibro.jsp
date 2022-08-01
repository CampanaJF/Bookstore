<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<%@include file="head.jsp"%>

	<title>Nuevo</title>

	<body class="orange lighten-4">
	
	<%@include file="header.jsp" %>
	

		<h3 style="color:red">${filesuccess}</h3>  
		<form:form method="post" action="savefile" enctype="multipart/form-data">  
		<p><label for="image">Choose Image</label></p>  
		<p><input name="file" id="fileToUpload" type="file" /></p>  
		<p><input type="submit" value="Upload"></p>  
		</form:form>  
		
		    
	
	
		<%@include file="footer.jsp" %>
	</body>
	
	
	
</html>