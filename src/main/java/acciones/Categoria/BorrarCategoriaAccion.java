package acciones.Categoria;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;


public class BorrarCategoriaAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		
		int id = Integer.parseInt(request.getParameter("id"));

		ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
		servicioCategorias.borrar(servicioCategorias.buscarPorClave(id));
		return ("Categoria.MostrarCategorias.do");

	}
}
