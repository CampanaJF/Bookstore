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

			<a href="" class="texto btn-large waves-effect waves-light orange darken-3">
				<i class="material-icons left">add</i>Agregar a Biblioteca</a>
            
            <!-- Dropdown Trigger -->
            <c:if test="${biblioteca == 'null'}">
            <a href="" class="dropdown-trigger texto btn-large waves-effect waves-light orange darken-3"
             data-target='dropdown1'>
                <i class="material-icons left">star</i>NA</a>
             </c:if>
             
             <c:if test="${biblioteca != 'null'}">
            <a href="" class="dropdown-trigger texto btn-large waves-effect waves-light orange darken-3"
             data-target='dropdown1'>
                <i class="material-icons left">star</i>${biblioteca.puntuacion}</a>
             </c:if>

                <!-- Dropdown Structure -->
                <ul id='dropdown1' class='texto dropdownonit dropdown-content'>
                    <li><a href="#!">(10) Obra Maestra</a></li>
                    <li><a href="#!">(9) Excelente</a></li>
                    <li><a href="#!">(8) Muy Bueno</a></li>
                    <li><a href="#!">(7) Bueno</a></li>
                    <li><a href="#!">(6) Ok</a></li>
                    <li><a href="#!">(5) Mediocre</a></li>
                    <li><a href="#!">(4) Malo</a></li>
                    <li><a href="#!">(3) Muy Malo</a></li>
                    <li><a href="#!">(2) Horrible</a></li>
                    <li><a href="#!">(1) Espantoso</a></li>
                </ul>

                <div class="ps1 row section valign-wrapper" >
                    <img class="icons" src="img/${libro.lenguaje}.svg">
                    
                    <c:if test="${libro.lenguaje == 'Espanol'}">
					  <p class="ps minitexto"> Espa&#241ol</p>
					</c:if>
					
					<c:if test="${libro.lenguaje != 'Espanol'}">
					  <p class="ps minitexto">${libro.lenguaje}</p>
					</c:if>

                    <span class="material-symbols-outlined iconrojo ps1">circle</span>
                    <span class="ps minitexto">Publicado: ${publicado} , libro.estado </span>
                    <span class="material-symbols-outlined notificationicon ps1">star</span>
                    <span class="ps minitexto">${libro.puntuacion}</span>
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
        <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
             Non aut aliquam pariatur alias aperiam molestiae, 
             veniam tempora ratione culpa in, earum quam. Id neque doloremque minima facilis officia, ex quia.
             Lorem ipsum dolor, sit amet consectetur adipisicing elit.
             Non aut aliquam pariatur alias aperiam molestiae, 
             veniam tempora ratione culpa in, earum quam. Id neque doloremque minima facilis officia, ex quia.</p>
     </blockquote>

     

     <h6 class="pt tituloprincipal">Rese&#241ias</h6>

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

               

	<%@include file="footer.jsp" %>

</body>
</html>