package acciones.Categoria;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Categoria;
import servicios.ServicioCategoriasImpl;




public class InsertarCategoriaAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		

	String StrNombre = request.getParameter("nomCategoria");
	new ServicioCategoriasImpl().insertar(new Categoria(StrNombre));
	return ("Categoria.MostrarCategorias.do");
	}
}
