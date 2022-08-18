package acciones.Categoria;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Categoria;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;


public class MostrarCategoriasAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){

		ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
			
		List<Categoria>ListaDeCategorias = servicioCategorias.buscarTodos();
			
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
			return "MostrarCategorias.jsp";
			
	}
}
	
