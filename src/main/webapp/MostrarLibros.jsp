<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import ="java.util.List"%>
<%@page import ="java.util.ArrayList"%>
<%@page import="beans.Libro"%>
<%@page import="beans.Categoria"%>
<%@page import="beans.Provedor"%>
<%@page import="dbHelpers.DataBaseException"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import= "servicios.ServicioCategorias"%>
<%@page import= "servicios.ServicioCategoriasImpl"%>


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
          <li class="active">
            <a href="Libro.MostrarLibros.do"><span class="fa fa-home mr-3"></span> Inicio</a>
          </li>
          <li>
              <a href="Categoria.MostrarCategorias.do"><span class="fa fa-user mr-3"></span> Categorias</a>
          </li>
          <li>
            <a href="Provedor.MostrarProvedores.do"><span class="fa fa-sticky-note mr-3"></span> Provedores</a>
          </li>
        </ul>

    	</nav>

        <!-- Page Content  -->
      <div id="content" class="p-4 p-md-5 pt-5">
      
        <a href="Libro.FormularioInsertarLibro.do">Insertar Nuevo Libro</a>
	      <form action="Libro.ControladorLibros.do" method="GET">
    
        <h2 class="mb-4">Cursodia | Java EE</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
      <!--
        <p class="navegar">
			<br><label>Categorias disonibles: </label>
			<select name="categoria">
			<option>Seleccionar</option>
				
				<c:forEach var="c" items="${ListaDeCategorias}">
					<option value ="${c.getid_cat()}">${c.getnom_cat()}</option>
				</c:forEach>
				
					
			</select>
			<input type="submit" value="Filtrar" /> 
	   </p> -->
     
        <table id="dtBasicExample" class="table table-striped cellspacing="0" width="100%">
          <thead>
            <tr>
              <th class="th-sm">Numero
              </th>
              <th class="th-sm">ISBN
              </th>
              <th class="th-sm">Titulo
              </th>
              <th class="th-sm">Categoria
              </th>
              <th class="th-sm">Precio
              </th>
              <th class="th-sm">Provedor
              </th>
              <th class="th-sm">Borrar
              </th>
              <th class="th-sm">Modificar
              </th>
            </tr>
          </thead>
          <tbody>
            
			<c:forEach var="lib" items="${ListaDeLibros}">
            <tr>
              <td>${lib.getnum_lib()}</td>
              <td>${lib.getisbn_lib()}</td>
              <td>${lib.gettit_lib()}</td>             
              <c:forEach var="c" items="${ListaDeCategorias}">
				<c:if test="${c.getid_cat()==lib.getcat_lib()}">
					<td>${c.getnom_cat()}</td>
				</c:if>
			</c:forEach>
              <td>${lib.getpre_lib()}</td>
              <c:forEach var="p" items="${ListaDeProvedores}">
				<c:if test="${p.getid_prov()==lib.getprov_lib()}">
					<td>${p.getnom_prov()}</td>
				</c:if>
			</c:forEach>
              <td><a href="Libro.BorrarLibro.do?id=${lib.getnum_lib()}">Borrar</a></td>
              <td><a href="Libro.FormularioEditarLibro.do?id=${lib.getnum_lib()}">Editar</a></td>
            </tr>
            </c:forEach>
          </tfoot>
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