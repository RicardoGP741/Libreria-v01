package acciones.Provedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Provedor;
import servicios.ServicioProvedoresImpl;



public class InsertarProvedorAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		
	String StrNombre = request.getParameter("nomProvedor");
	new ServicioProvedoresImpl().insertar(new Provedor(StrNombre));

	return ("Provedor.MostrarProvedores.do");
	}
}
