<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>
        <!--Style sheets-->
           <link href="css/styles.css" rel="stylesheet">
        <link href="css/parallax.css" rel="stylesheet">
        <link href="css/buttonstyle.css" rel="stylesheet">
        <link href="css/fonts.css" rel="stylesheet">
        <link href="css/tools.css" rel="stylesheet">
    
        
    </head>
	
<title>Resultados</title>

<body class="orange lighten-4">
	
    <c:if test="${not empty libros}">  

        <ul class="collection">
    
            <c:forEach items="${libros}" var="libro"> 
    
            <li class="collection-item avatar">
              <img src="img/${portada}.jpeg" alt="" class="circle">
              <span class="title">${libro.titulo} ${libro.autor.nombre}</span>
            </li>
    
            </c:forEach>
    
          </ul>
    
    </c:if>
    

    <div class="section"></div>

    <c:if test="${not empty autores}">  

    <ul class="collection">

        <c:forEach items="${autores}" var="autor"> 

        <li class="collection-item avatar">
          <img src="img/${foto}.jpg" alt="" class="circle">
          <span class="title">${autor.apellido} ${autor.nombre}</span>
        </li>

        </c:forEach>

      </ul>

    </c:if>

    <div class="section"></div>

    
    <c:if test="${not empty usuarios}">  

    <ul class="collection">

        <c:forEach items="${usuarios}" var="usuario"> 

        <li class="collection-item avatar">
          <img src="img/${foto}.jpg" alt="" class="circle">
          <span class="title">${usuario.nombre}</span>
        </li>

        </c:forEach>

      </ul>

    </c:if>


    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="js/materialize.js"></script>
    <script src="js/init.js"></script>

</body>
</html>