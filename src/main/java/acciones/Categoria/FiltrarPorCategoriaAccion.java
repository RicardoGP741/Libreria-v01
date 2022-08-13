package acciones.Categoria;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Categoria;
import beans.Libro;
import dbHelpers.DataBaseException;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;
import servicios.ServicioLibros;
import servicios.ServicioLibrosImpl;

public class FiltrarPorCategoriaAccion extends Accion{
	
	@SuppressWarnings("static-access")
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws DataBaseException{


		int C = Integer.parseInt(request.getParameter("categoria"));

		ServicioLibros servicioLibros = new ServicioLibrosImpl();
		ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
			
		List<Libro> ListaDeLibros = servicioLibros.buscarTodos();
		List<Categoria>ListaDeCategorias = servicioCategorias.buscarLasCategorias();
			
			request.setAttribute("ListaDeLibros", ListaDeLibros);
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
		
		return "MostrarLibros.jsp";
	}
}
