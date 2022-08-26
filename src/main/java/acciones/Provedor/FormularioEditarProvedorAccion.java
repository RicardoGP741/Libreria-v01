package acciones.Provedor;

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

public class FormularioEditarProvedorAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
	

		int idProv = Integer.parseInt(request.getParameter("id"));  
		ServicioProvedores servicioProvedores =  (ServicioProvedores) getBean("ServicioProvedores", request);
		
		Provedor prov = servicioProvedores.buscarPorClave(idProv);

		List<Provedor>ListaDeProvedores = servicioProvedores.buscarTodos();	
			request.setAttribute("ListaDeProvedores", ListaDeProvedores);
			request.setAttribute("prov", prov);
			
			return ("FormularioEditarProvedor.jsp?id="+idProv);
			
	}
}
	

