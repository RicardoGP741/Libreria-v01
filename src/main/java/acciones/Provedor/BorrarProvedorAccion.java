package acciones.Provedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import servicios.ServicioProvedores;
import servicios.ServicioProvedoresImpl;

public class BorrarProvedorAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		
		int id = Integer.parseInt(request.getParameter("id"));
		ServicioProvedores servicioProvedores =  (ServicioProvedores) getBean("ServicioProvedores", request);

		servicioProvedores.borrar(servicioProvedores.buscarPorClave(id));
		return ("Provedor.MostrarProvedores.do");

	}
}
