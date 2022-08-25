package acciones.Provedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Provedor;
import servicios.ServicioProvedores;
import servicios.ServicioProvedoresImpl;

public class EditarProvedorAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){

		int id = Integer.parseInt(request.getParameter("id"));
		
		String StrNom = request.getParameter("nomProvedor");

		ServicioProvedores servicioProvedores =  (ServicioProvedores) getBean("ServicioProvedores", request);
		Provedor Provedor = servicioProvedores.buscarPorClave(id);
		Provedor.setnom_prov(StrNom);
		servicioProvedores.guardarCambios(Provedor);
		return ("Provedor.MostrarProvedores.do");
		
		
	}
}
