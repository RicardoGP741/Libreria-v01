package acciones.Libro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import servicios.ServicioLibros;
import servicios.ServicioLibrosImpl;

public class BorrarLibroAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		
		int id = Integer.parseInt(request.getParameter("id"));
		ServicioLibros servicioLibros = (ServicioLibros) getBean("ServicioLibros", request);
		servicioLibros.borrar(servicioLibros.buscarPorClave(id));
		return "Libro.MostrarLibros.do";

	}
}
