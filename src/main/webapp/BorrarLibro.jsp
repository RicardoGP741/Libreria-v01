<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="javaEEJDBC.Libro"%>
<%@ page import="javaEEJDBC.DataBaseException"%>

<%
	String libID= request.getParameter("id");
	int id = Integer.parseInt(libID);
	boolean error=false;
	Libro lib=new Libro();
	try{
		lib.BorrarLibro(id);
		response.sendRedirect("MostrarLibros.jsp");
	}catch(DataBaseException e){
		%>
			<%response.sendRedirect("Errores.jsp?motivo="+e.getMessage());%>
			<%System.out.println("EXCEPCION: "+e.getMessage());  %>
			<%error=true; %>
			<%out.println("Ha ocurrido un error ): "+e.getMessage());  %>
		<%
	}
	if(!error){
		//response.sendRedirect("MostrarLibros.jsp");
		//en teoria esto valida que si hay error se quede mostrandolo y si sirve siga el flujo pero lo puse arriba xD
		//Asi que puedo borrar todo este if y el bolean error
	}
	System.out.println("");
	
%>