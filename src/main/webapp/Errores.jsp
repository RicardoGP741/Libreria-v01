<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Error</title>
		<link rel="stylesheet" href="css/formularios.css">
	</head>
	<body background="img/formulario.jpg">
	
		<% String motivo= request.getParameter("motivo"); %>
		<div class=formulario>
		<h1>El error se solucionar� una vez que nuestro colaborador termine 
		su hamburguesa</h1>
		<h4><%=motivo%></h4>
		<br>
		<img src="img/error2.jpg" width="340px"/>
		<br>
		<a href="MostrarLibros.jsp">Reiniciar</a>
		</div>
	</body>
</html>



