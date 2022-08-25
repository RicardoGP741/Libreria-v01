package acciones.Provedor;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Provedor;
import dao.CategoriaDAO;
import dao.LibroDAO;
import dao.ProvedoresDAO;
import servicios.ServicioCategorias;
import servicios.ServicioLibros;
import servicios.ServicioProvedores;
import servicios.ServicioProvedoresImpl;


public class MostrarProvedoresAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){

		ServicioProvedores servicioProvedores =  (ServicioProvedores) getBean("ServicioProvedores", request);
		
		List<Provedor>ListaDeProvedores = servicioProvedores.buscarTodos();		
			request.setAttribute("ListaDeProvedores", ListaDeProvedores);
			return "MostrarProvedores.jsp";
			
	}
}
	
