<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javaEEJDBC.Libro"%>
<%@ page import="javaEEJDBC.DataBaseException"%>

<%
	String StrISBN = request.getParameter("ISBN");
	String StrTitulo = request.getParameter("Titulo");
	String Cat = request.getParameter("Categoria");
	String Pre = request.getParameter("Precio");
	
	int filas =0;
	try{
		filas = new Libro(StrISBN, StrTitulo, 
				Integer.parseInt(Cat), 
				Float.parseFloat(Pre)).insertar();
		response.sendRedirect("MostrarLibros.jsp");
	}catch(DataBaseException e)
	{
		System.out.println("Entro la excepcion :D");
	%>
	<% 
		out.println(e.getMessage());  
		response.sendRedirect("Errores.jsp?motivo="+e.getMessage());
	}%>
	<%
	System.out.println("FILAS MODIFICADAS: "+filas);	
	
	
	
	if(filas!=0){
		//response.sendRedirect("MostrarLibros.jsp");
		//SI SE CUMPLE EL TRY SE SIGUE EL FLUJO, SI ENTRA EL CATCH SE ESTANCA AQUI POR LO QUE NO OCUPO EL IF
	}else{
		
	}
	
	%>
	
%>
