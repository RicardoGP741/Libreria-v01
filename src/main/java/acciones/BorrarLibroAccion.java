package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Libro;
import dao.LibroDAO;
import dbHelpers.DataBaseException;
import dbHelpers.HibernateHelper;

public class BorrarLibroAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		LibroDAO libDAO = new LibroDAO();
		libDAO.BorrarLibro(libDAO.buscarLibro(id));
		return "MostrarLibros.do";

	}
}
