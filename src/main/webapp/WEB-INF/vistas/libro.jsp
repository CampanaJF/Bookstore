<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>


<%@include file="head.jsp"%>


	<title>${libro.titulo}</title>


	<body class="orange lighten-4">
	
	
<%@include file="header.jsp" %>



	<!--Container-->
	<div class="container">
	<div class="row section">
		
		<div class="col s6 m6 l5">
			<img class="portadalibro" src="img/brujero.jpg">
			
		</div>

		<div class=" col s6 m6 l7">

		<div class="row ps1">
			
			<h4 class="tituloprincipal">${libro.titulo}</h4>
			<h6 class=" tituloprincipal">${libro.autor.nombre} ${libro.autor.apellido}</h6>
			

	             			
<%--Dropdown Trigger Cambiar Estado--%>			
				<c:if test="${not empty biblioteca}"> 
				<a href="" class="dropdown-trigger texto btn-large waves-effect waves-light orange darken-3"
	             data-target='dropdown2'>Estado: ${biblioteca.estado}</a>
            	</c:if>

<%-- Dropdown Structure Cambiar Estado  --%>

				<ul id='dropdown2' class='texto dropdownonit dropdown-content'>
                   <li><a href="<c:url value="/biblioteca/cambiarEstado?libroId=${libro.id}&&estado=Nuevo"/>">Nuevo</a></li>
                   <li><a href="<c:url value="/biblioteca/cambiarEstado?libroId=${libro.id}&&estado=Pausa"/>">Pausa</a></li>
                   <li><a href="<c:url value="/biblioteca/cambiarEstado?libroId=${libro.id}&&estado=Progreso"/>">Progreso</a></li>
                   <li><a href="<c:url value="/biblioteca/cambiarEstado?libroId=${libro.id}&&estado=Terminado"/>">Terminado</a></li>
                   <li><a href="<c:url value="/biblioteca/cambiarEstado?libroId=${libro.id}&&estado=Dejado"/>">Dejado</a></li>
                </ul>

<%--Agregar--%>
				<c:if test="${empty biblioteca}"> 
				<a href="<c:url value="/biblioteca/agregar?libroId=${libro.id}" />"
			    class="texto btn-large waves-effect waves-light orange darken-3">
				<i class="material-icons left">add</i>Agregar a Biblioteca</a>
            	</c:if>
            	
<%-- Dropdown Trigger PUNTUACION  --%>
             	<c:if test="${not empty biblioteca}">
             	
	            <a href="" class="dropdown-trigger texto btn-large waves-effect waves-light orange darken-3"
	             data-target='dropdown1'>
                <i class="material-icons left">star</i>
                <c:if test="${empty biblioteca.puntuacion}">NA</c:if>
                <c:if test="${not empty biblioteca.puntuacion}">${biblioteca.puntuacion}</c:if>
                </a>
            

<%-- Dropdown Structure PUNTUACION  --%>
                <ul id='dropdown1' class='texto dropdownonit dropdown-content'>
                    <li><a href="<c:url value="/biblioteca/puntuar?libroId=${libro.id}&&puntuacion=10.0"/>">(10) Obra Maestra</a></li>
                    <li><a href="<c:url value="/biblioteca/puntuar?libroId=${libro.id}&&puntuacion=9.0"/>">(9) Excelente</a></li>
                    <li><a href="<c:url value="/biblioteca/puntuar?libroId=${libro.id}&&puntuacion=8.0"/>">(8) Muy Bueno</a></li>
                    <li><a href="<c:url value="/biblioteca/puntuar?libroId=${libro.id}&&puntuacion=7.0"/>">(7) Bueno</a></li>
                    <li><a href="<c:url value="/biblioteca/puntuar?libroId=${libro.id}&&puntuacion=6.0"/>">(6) Ok</a></li>
                    <li><a href="<c:url value="/biblioteca/puntuar?libroId=${libro.id}&&puntuacion=5.0"/>">(5) Mediocre</a></li>
                    <li><a href="<c:url value="/biblioteca/puntuar?libroId=${libro.id}&&puntuacion=4.0"/>">(4) Malo</a></li>
                    <li><a href="<c:url value="/biblioteca/puntuar?libroId=${libro.id}&&puntuacion=3.0"/>">(3) Muy Malo</a></li>
                    <li><a href="<c:url value="/biblioteca/puntuar?libroId=${libro.id}&&puntuacion=2.0"/>">(2) Horrible</a></li>
                    <li><a href="<c:url value="/biblioteca/puntuar?libroId=${libro.id}&&puntuacion=1.0"/>">(1) Espantoso</a></li>
                </ul>
              
                
                 </c:if>
            


                <div class="ps1 row section valign-wrapper" >
                    
                    
                    <c:if test="${libro.lenguaje == 'Espanol'}">
                      <img src="<c:url value="img/Espanol.svg"/>">
					  <p class="ps minitexto"> Espa&#241ol</p>
					</c:if>
					
					<c:if test="${libro.lenguaje != 'Espanol'}">
					  <img src="<c:url value="/img/${libro.lenguaje}.svg"/>">
					  <img src="<c:url value="/img/${libro.lenguaje}.png"/>">
					  <img src="<c:url value="/img/united-kingdom-pngrepo-com.png"/>">
					  <img src="<c:url value="/img/${libro.lenguaje}.jpg"/>">
					  <p class="ps minitexto">${libro.lenguaje}</p>
					</c:if>

					<span class="ps minitexto">| Publicado: ${libro.publicadoS}</span>
					
					<c:choose>
					<c:when test="${libro.serie.estado == 'Progreso'}">
                    <span class="material-symbols-outlined iconverde ps1">circle</span>
                    </c:when>
                    <c:when test="${libro.serie.estado == 'Pausa'}">
                    <span class="material-symbols-outlined iconazul ps1">circle</span>
                    </c:when>
                    <c:otherwise>
                    <span class="material-symbols-outlined iconrojo ps1">circle</span>
                    </c:otherwise>
                    </c:choose>
                    
                    <span class="ps minitexto">| ${libro.serie.estado} </span>
                    <span class="material-symbols-outlined notificationicon ps1">star</span>
                    <span class="ps minitexto">| ${libro.puntuacion}</span>
                </div>

            
                <span class=" col l2 texto mt1 HeavyWeaponsGuy meSpecial">Generos:</span>
                <ul class="tags col l10">
                
                <c:forEach items="${generos}" var="genero">
                
                    <li><a href=""><span data-badge-caption="${genero.genero}"
                         class="blue lighten-2 new badge"></span></a></li>
                         
                 </c:forEach>
                   
                </ul>

                <span class="col l2 texto mt1 HeavyWeaponsGuy meSpecial">Temas:</span>
                <ul class="tags col l10">
                
                <c:forEach items="${temas}" var="tema">
                
                    <li><a href=""><span data-badge-caption="${tema.tema}"
                         class="blue lighten-2 new badge"></span></a></li>
                         
                 </c:forEach>
               
                  
                </ul>
   
		</div>

		</div>

        

	</div>
	
	

    <h6 class=" tituloprincipal">Sinopsis</h6>
    <blockquote class="ps1 texto"> 
        <p>${libro.sinopsis}</p>
     </blockquote>

     

     <h6 class="pt tituloprincipal">Rese&#241ias</h6>

				<c:if test="${empty usuario}">
               <div class="row">
                    <form class="col s12">
                    <div class="row">
                    <div class="input-field col s12">
                         <textarea id="textarea2" class="materialize-textarea" data-length="120"></textarea>
                         <label  for="textarea2">Escribi Tu Rese&#241a</label>
                         <button href="" type="submit" class="texto btn waves-effect waves-light orange darken-3">
                         <i class="material-icons left">send</i>Publicar</button>
                    </div>
                    </div>
                    </form>
               </div>
               
               </c:if>
          
               <div class="mb0 pb row section valign-wrapper" >
                    <img class="icons circle" src="img/favicon-32x32.png">
                    <span class="ps minitexto">Apelldio Nombre</span>
                    <span class="material-symbols-outlined notificationicon ps1">star</span>
                    <span class="ps minitexto">9.99</span>
                </div>

               <blockquote class=" texto"> 
                    <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                    Non aut aliquam pariatur alias aperiam molestiae, 
                    veniam tempora ratione culpa in, earum quam. Id neque doloremque minima facilis officia, ex quia.
                    Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                    Non aut aliquam pariatur alias aperiam molestiae, 
                    veniam tempora ratione culpa in, earum quam. Id neque doloremque minima facilis officia, ex quia.</p>
               </blockquote>


               <div class="mb0 pb row section valign-wrapper" >
                    <img class="icons circle" src="img/favicon-32x32.png">
                    <span class="ps minitexto">Apelldio Nombre</span>
                    <span class="material-symbols-outlined notificationicon ps1">star</span>
                    <span class="ps minitexto">9.99</span>
                </div>

               <blockquote class=" texto"> 
                    <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                    Non aut aliquam pariatur alias aperiam molestiae, 
                    veniam tempora ratione culpa in, earum quam. Id neque doloremque minima facilis officia, ex quia.
                    Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                    Non aut aliquam pariatur alias aperiam molestiae, 
                    veniam tempora ratione culpa in, earum quam. Id neque doloremque minima facilis officia, ex quia.</p>
               </blockquote>

               <div class="mb0 mt pb row section valign-wrapper" >
                    <img class="icons circle" src="img/favicon-32x32.png">
                    <span class="ps minitexto">Apelldio Nombre</span>
                    <span class="material-symbols-outlined notificationicon ps1">star</span>
                    <span class="ps minitexto">9.99</span>
                </div>

               <blockquote class=" texto"> 
                    <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                    Non aut aliquam pariatur alias aperiam molestiae, 
                    veniam tempora ratione culpa in, earum quam. Id neque doloremque minima facilis officia, ex quia.
                    Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                    Non aut aliquam pariatur alias aperiam molestiae, 
                    veniam tempora ratione culpa in, earum quam. Id neque doloremque minima facilis officia, ex quia.</p>
               </blockquote>

       </div>        

	<%@include file="footer.jsp" %>

</body>
</html>