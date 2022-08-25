package acciones.Provedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Provedor;
import servicios.ServicioProvedores;
import servicios.ServicioProvedoresImpl;



public class InsertarProvedorAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		
	String StrNombre = request.getParameter("nomProvedor");
	ServicioProvedores servicioProvedores =  (ServicioProvedores) getBean("ServicioProvedores", request);
	servicioProvedores.insertar(new Provedor(StrNombre));

	return ("Provedor.MostrarProvedores.do");
	}
}
