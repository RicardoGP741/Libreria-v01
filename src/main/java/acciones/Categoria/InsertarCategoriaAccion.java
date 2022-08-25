package acciones.Categoria;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Categoria;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;




public class InsertarCategoriaAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		

	String StrNombre = request.getParameter("nomCategoria");
	ServicioCategorias servicioCategorias =  (ServicioCategorias) getBean("ServicioCategorias", request);
	servicioCategorias.insertar(new Categoria(StrNombre));
	return ("Categoria.MostrarCategorias.do");
	}
}
