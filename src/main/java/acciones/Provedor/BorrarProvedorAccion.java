package acciones.Provedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import acciones.Accion;
import beans.Libro;
import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import dbHelpers.DataBaseException;
import dbHelpers.HibernateHelper;
import servicios.ServicioLibros;
import servicios.ServicioLibrosImpl;
import servicios.ServicioProvedores;
import servicios.ServicioProvedoresImpl;

public class BorrarProvedorAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		
		int id = Integer.parseInt(request.getParameter("id"));
		ServicioProvedores servicioProvedores = new ServicioProvedoresImpl();

		servicioProvedores.borrar(servicioProvedores.buscarPorClave(id));
		return ("Provedor.MostrarProvedores.do");

	}
}
