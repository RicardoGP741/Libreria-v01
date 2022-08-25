package acciones.Libro;

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

public class FormularioInsertarLibroAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
	
		ServicioCategorias servicioCategorias =  (ServicioCategorias) getBean("ServicioCategorias", request);
		ServicioProvedores servicioProvedores =  (ServicioProvedores) getBean("ServicioProvedores", request);
		
		List<Categoria>ListaDeCategorias = servicioCategorias.buscarTodos();
		List<Provedor>ListaDeProvedores = servicioProvedores.buscarTodos();	
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
			request.setAttribute("ListaDeProvedores", ListaDeProvedores);
			
			return "FormularioInsertarLibro.jsp";
			
	}
}
	

