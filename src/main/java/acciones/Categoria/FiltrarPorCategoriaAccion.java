package acciones.Categoria;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Categoria;
import beans.Libro;
import dao.CategoriaDAO;
import dao.LibroDAO;
import dbHelpers.DataBaseException;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;
import servicios.ServicioLibros;
import servicios.ServicioLibrosImpl;

public class FiltrarPorCategoriaAccion extends Accion{
	
	@SuppressWarnings("static-access")
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws DataBaseException{

		//no se esta usando*********
		int C = Integer.parseInt(request.getParameter("categoria"));

		ServicioLibros servicioLibros = (ServicioLibros) getBean("ServicioLibros", request);
		ServicioCategorias servicioCategorias =  (ServicioCategorias) getBean("ServicioCategorias", request);
		LibroDAO libroDAO = (LibroDAO) getBean("LibroDAO", request);
		servicioLibros.setLibroDAO(libroDAO);
		CategoriaDAO categoriaDAO = (CategoriaDAO) getBean("CategoriaDAO", request);
		servicioCategorias.setCategoriaDAO(categoriaDAO);
		
		//List<Libro> ListaDeLibros = servicioLibros.buscarPorCategoria(C)
		List<Categoria>ListaDeCategorias = servicioCategorias.buscarLasCategorias();
			
			//request.setAttribute("ListaDeLibros", ListaDeLibros);
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
		
		return "MostrarLibros.jsp";
	}
}
