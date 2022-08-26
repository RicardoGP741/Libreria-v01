<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import ="java.util.List"%>
<%@page import ="java.util.ArrayList"%>
<%@page import="beans.Categoria"%>
<%@page import="dbHelpers.DataBaseException"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<html lang="en">
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
	  		<h1><a href="#" class="logo">Libreria</a></h1>
        <ul class="list-unstyled components mb-5">
          <li>
            <a href="Libro.MostrarLibros.do"><span class="fa fa-sticky-note mr-3"></span> Inicio</a>
          </li>
          <li  class="active">
              <a href="Categoria.MostrarCategorias.do"><span class="fa fa-home mr-3"></span> Categorias</a>
          </li>
          <li>
            <a href="Provedor.MostrarProvedores.do"><span class="fa fa-sticky-note mr-3"></span> Provedores</a>
          </li>
        </ul>

    	</nav>

        <!-- Page Content  -->
      <div id="content" class="p-4 p-md-5 pt-5">
		<a href="FormularioInsertarCategoria.jsp">Insertar Nueva Categoria</a>
		
	      <form action="ControladorLibros.do" method="GET">
    
        <h2 class="mb-4">Cursodia | Java EE</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
      
        <table class="table">
          <thead>
            
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Nombre Categoria</th>
              <th class="th-sm">Borrar</th>
              <th class="th-sm">Modificar</th>
            </tr>
          </thead>
          
          <tbody>
            <c:forEach var="cat" items="${ListaDeCategorias}">
	            <tr>
	              <td>${cat.getid_cat()}</td>
	              <td>${cat.getnom_cat()}</td>
				  <td><a href="Categoria.BorrarCategoria.do?id=${cat.getid_cat()}">Borrar</a></td>
              	  <td><a href="Categoria.FormularioEditarCategoria.do?id=${cat.getid_cat()}">Editar</a></td>
	            </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
		</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/datatables.min.js"></script>
    <script src="js/datatables-select.min.js"></script>
  </body>
</html>