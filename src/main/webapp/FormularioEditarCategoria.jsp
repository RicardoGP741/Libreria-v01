<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import="java.sql.SQLException" %>
<%@page import="beans.Categoria"%>
<%@page import="servicios.ServicioCategorias"%>
<%@page import="servicios.ServicioCategoriasImpl"%>
<html lang="es">
	<%
	 int idCat = Integer.parseInt(request.getParameter("id"));  //AQUI SE DEBERIA RECIBIR EL PARAMET
	%>
  <head>
  	<title>Libreria</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="css/style.css">

  </head>
  <body>
		
		<div class="wrapper d-flex align-items-stretch">
			<nav id="sidebar">
				<div class="custom-menu">
					<button type="button" id="sidebarCollapse" class="btn btn-primary">
	          <i class="fa fa-bars"></i>
	          <span class="sr-only">Menu</span>
	        </button>
        </div>
	  		<h1><a href="index.html" class="logo">Libreria</a></h1>
        <ul class="list-unstyled components mb-5">
          <li>
            <a href="Libro.MostrarLibros.do"><span class="fa fa-home mr-3"></span> Inicio</a>
          </li>
          <li  class="active">
              <a href="Categoria.MostrarCategorias.do"><span class="fa fa-user mr-3"></span> Categorias</a>
          </li>
          <li>
            <a href="Provedor.MostrarProvedores.do"><span class="fa fa-sticky-note mr-3"></span> Provedores</a>
          </li>
        </ul>

    	</nav>

        <!-- Page Content  -->
      <div id="content" class="p-4 p-md-5 pt-5">
	
          <h1>Formulario Editar Libro</h1>
          <form action="Categoria.EditarCategoria.do" method="GET" class="needs-validation">
            <div class="form-group">
              <label for="ID">ID:</label>
              <input type="text" class="form-control" id="ID" name="idCateg" value="${cat.getid_cat()}" readonly>
            </div>
            <div class="form-group">
              <label for="Categ">Nombre de la categoria:</label>
              <input type="text" class="form-control" id="Categ" name="CategNom" value="${cat.getnom_cat()}" required>
            </div>


            <button type="submit" class="btn btn-primary" onClick="insertar();">Actualizar</button>

            <p class="navegar"><a href="Categoria.MostrarCategorias.do">Cancelar</a></p>
          </form>

      </div>
		</div>
    <script>
      
    </script>
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/datatables.min.js"></script>
    <script src="js/datatables-select.min.js"></script>
  </body>
</html>