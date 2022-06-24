package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import dao.LibroDAO;
import dbHelpers.DataBaseException;

public class InsertarLibroAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		
	String StrISBN = request.getParameter("ISBN");
	String StrTitulo = request.getParameter("nomLibro");
	String Cat = request.getParameter("catLibro");
	String Pre = request.getParameter("preLibro"); 
	new LibroDAO().insertar(new Libro(StrISBN, StrTitulo, Integer.parseInt(Cat), Float.parseFloat(Pre)));

	return ("MostrarLibros.do");
	}
}
