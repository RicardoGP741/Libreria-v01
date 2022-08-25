package acciones.Libro;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Categoria;
import beans.Libro;
import beans.Provedor;
import dao.CategoriaDAO;
import dao.LibroDAO;
import dao.ProvedoresDAO;
import servicios.ServicioCategorias;
import servicios.ServicioLibros;
import servicios.ServicioProvedores;

public class MostrarLibrosAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
	
		ServicioLibros servicioLibros = (ServicioLibros) getBean("ServicioLibros", request);
		ServicioCategorias servicioCategorias =  (ServicioCategorias) getBean("ServicioCategorias", request);
		ServicioProvedores servicioProvedores =  (ServicioProvedores) getBean("ServicioProvedores", request);

		List<Libro> ListaDeLibros = servicioLibros.buscarTodos();
		List<Categoria>ListaDeCategorias = servicioCategorias.buscarTodos();
		List<Provedor>ListaDeProvedores = servicioProvedores.buscarTodos();
			
			request.setAttribute("ListaDeLibros", ListaDeLibros);
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
			request.setAttribute("ListaDeProvedores", ListaDeProvedores);

			
			return "MostrarLibros.jsp";
			
	}
}
	
