package acciones.Provedor;

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

public class EditarProvedorAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){

		int id = Integer.parseInt(request.getParameter("id"));
		
		String StrNom = request.getParameter("nomProvedor");

	
		ServicioProvedores servicioProvedores = new ServicioProvedoresImpl();
		Provedor Provedor = servicioProvedores.buscarPorClave(id);
		Provedor.setnom_prov(StrNom);

		servicioProvedores.guardarCambios(Provedor);
		return ("Provedor.MostrarProvedores.do");
		
		
	}
}
