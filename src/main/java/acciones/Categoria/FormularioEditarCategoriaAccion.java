package acciones.Categoria;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Categoria;
import beans.Libro;
import beans.Provedor;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;
import servicios.ServicioLibros;
import servicios.ServicioLibrosImpl;
import servicios.ServicioProvedores;
import servicios.ServicioProvedoresImpl;

public class FormularioEditarCategoriaAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
	

		int idCat = Integer.parseInt(request.getParameter("id"));  
		
		ServicioCategorias servicioCategorias =  (ServicioCategorias) getBean("ServicioCategorias", request);
		
		Categoria cat = servicioCategorias.buscarPorClave(idCat);
		
		List<Categoria>ListaDeCategorias = servicioCategorias.buscarTodos();

			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
			request.setAttribute("cat", cat);
			
			return ("FormularioEditarCategoria.jsp?id="+idCat);
			
	}
}
	

