package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import beans.Libro;
import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;
import dbHelpers.DataBaseException;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;
import servicios.ServicioLibros;
import servicios.ServicioLibrosImpl;

public class FiltrarPorCategoriaAccion extends Accion{
	
	@SuppressWarnings("static-access")
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){


		int C = Integer.parseInt(request.getParameter("categoria"));

		ServicioLibros servicioLibros = new ServicioLibrosImpl();
		ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
			
		List<Libro> ListaDeLibros = servicioLibros.buscarTodos();
		List<Integer>ListaDeCategorias = servicioCategorias.buscarLasCategorias();
			
			request.setAttribute("ListaDeLibros", ListaDeLibros);
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
		
		return "MostrarLibros.jsp";
	}
}
