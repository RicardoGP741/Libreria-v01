package acciones.Categoria;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Categoria;
import dao.CategoriaDAO;
import dao.LibroDAO;
import dao.ProvedoresDAO;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;
import servicios.ServicioLibros;
import servicios.ServicioProvedores;


public class MostrarCategoriasAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){

		ServicioCategorias servicioCategorias =  (ServicioCategorias) getBean("ServicioCategorias", request);
		CategoriaDAO categoriaDAO = (CategoriaDAO) getBean("CategoriaDAO", request);
		servicioCategorias.setCategoriaDAO(categoriaDAO);
			
		List<Categoria>ListaDeCategorias = servicioCategorias.buscarTodos();
			
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
			return "MostrarCategorias.jsp";
			
	}
}
	
