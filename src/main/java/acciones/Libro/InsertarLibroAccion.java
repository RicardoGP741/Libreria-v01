package acciones.Libro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Libro;
import servicios.ServicioLibrosImpl;



public class InsertarLibroAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		
	String StrISBN = request.getParameter("ISBN");
	String StrTitulo = request.getParameter("nomLibro");
	String Cat = request.getParameter("catLibro");
	String Pre = request.getParameter("preLibro"); 
	String Prov = request.getParameter("provLibro");
	new ServicioLibrosImpl().insertar(new Libro(StrISBN, StrTitulo, Integer.parseInt(Cat), Float.parseFloat(Pre), Integer.parseInt(Prov)));

	return ("Libro.MostrarLibros.do");
	}
}
