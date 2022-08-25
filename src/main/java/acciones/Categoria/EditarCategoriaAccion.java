package acciones.Categoria;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Categoria;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;

public class EditarCategoriaAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){

		int id = Integer.parseInt(request.getParameter("idCateg"));
		
		String StrNom = request.getParameter("CategNom");

	
		ServicioCategorias servicioCategorias =  (ServicioCategorias) getBean("ServicioCategorias", request);
		Categoria categoria = servicioCategorias.buscarPorClave(id);
		categoria.setnom_cat(StrNom);

		servicioCategorias.guardarCambios(categoria);
		return "Categoria.MostrarCategorias.do";
		
		
	}
}
