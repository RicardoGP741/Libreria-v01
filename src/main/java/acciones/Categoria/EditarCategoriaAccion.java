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
		System.out.println(request.getParameter("idCateg") + request.getParameter("CategNom"));
		int id = Integer.parseInt(request.getParameter("idCateg"));
		
		String StrNom = request.getParameter("CategNom");

	
		ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
		Categoria categoria = servicioCategorias.buscarPorClave(id);
		categoria.setnom_cat(StrNom);

		servicioCategorias.guardarCambios(categoria);
		return "Categoria.MostrarCategorias.do";
		
		
	}
}
