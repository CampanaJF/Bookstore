<!--Nav-->
<div class="navbar-fixed">
	<nav class="teal lighten-5" role="navigation">
		<div class="nav-wrapper container">
		  <a id="logo-container" href="home" class="brand-logo">
			<img class="pt" src="img/favicon-32x32.png"></a>

				<a href="#" data-target="nav-mobile" class="sidenav-trigger">
					 <i class="material-icons">menu</i></a>

		<%--No session --%>
		<c:if test="${empty usuario}">
			
		  <ul class="right hide-on-med-and-down">
		
			<li><a class="valign-wrapper" href="biblioteca">
				<span class="material-symbols-outlined">auto_stories</span><span class="ps">Biblioteca</span></a>
			</li>

			<li><a class="valign-wrapper" href="nuevoLibro">
				<span class="material-symbols-outlined">history_edu</span><span class="ps">Nuevo Libro</span></a>
			</li>

			<li><a class="valign-wrapper" href="#">
				<span class="material-symbols-outlined notificationicon">workspace_premium</span>
				<span class="ps">&#161Hacete Premium!</span></a>
			</li>

			
			<li><a class="valign-wrapper" href="login">
				<span class="material-symbols-outlined">login</span><span class="ps">Login</span></a>
			</li>

			<li><a class="valign-wrapper" href="registrarse">
				<span class="material-symbols-outlined">app_registration</span><span class="ps">Registrarse</span></a>
			</li>

		  </ul>
		  
		  </c:if>

		<%--session --%>
		<c:if test="${not empty usuario}">
		
	
		  <ul class="right hide-on-med-and-down">
		
			<li><a class="valign-wrapper" href="biblioteca">
				<span class="material-symbols-outlined">auto_stories</span><span class="ps">Biblioteca</span></a>
			</li>

			<li><a class="valign-wrapper" href="librogen">
				<span class="material-symbols-outlined">history_edu</span><span class="ps">Nuevo Libro</span></a>
			</li>

			<li><a class="valign-wrapper" href="#">
				<span class="material-symbols-outlined notificationicon">workspace_premium</span>
				<span class="ps">&#161Hacete Premium!</span></a>
			</li>
			
			<li><a class="valign-wrapper" href="#">
				<span class="material-symbols-outlined">person</span>
				<span class="ps">Perfil</span></a>
			</li>
			
			<li>
				<a class="valign-wrapper" href="">
					<span class="material-symbols-outlined notificationicon">notifications</span>
					<span class="subtitulo">4!</span></a>
			</li>
			
			<li><a class="valign-wrapper" href="logout">
				<span class="material-symbols-outlined">logout</span><span class="ps">Logout</span></a>
			</li>
	
		  </ul>
		  
		  </c:if>
		   </div>	
	</nav>


</div>


 <div id="navmobile">
	  <ul id="nav-mobile" class="sidenav">

		   <li><a class="" href="biblioteca">
				<i class="material-icons">auto_stories</i>Biblioteca</a></li>

		   <li><a class="valign-wrapper" href="#">
				<i class="material-symbols-outlined">history_edu</i>Nuevo Libro</a></li>

		   <li><a class="valign-wrapper" href="#">
		   <i class="material-symbols-outlined notificationicon">workspace_premium</i>&#161Hacete Premium!</a></li>

		   <li><a class="guh" href="#">
				<i class="material-symbols-outlined">person</i>Perfil</a></li>

		   <li><a class="valign-wrapper" href="#">
				<i class="material-symbols-outlined">door_open</i>Login</a></li>

		   <li><a class="valign-wrapper" href="#">
				<i class="material-symbols-outlined">app_registration</i>Registrarse</a></li>

		   <li><a class="valign-wrapper" href="">
				<i class="material-symbols-outlined notificationicon">notifications</i>4!</a></li>
	  </ul>
 </div>
	
	
