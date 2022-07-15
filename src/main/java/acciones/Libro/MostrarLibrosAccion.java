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

public class MostrarLibrosAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
	
		System.out.println("Se netra a la MostrarLibrosAccion");


		//LibroDAOJPAImpl DAOlib = new LibroDAOJPAImpl(); 
		//CategoriaDAOJPAImpl DAOcat = new CategoriaDAOJPAImpl();
		ServicioLibros servicioLibros = new ServicioLibrosImpl();
		ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
		ServicioProvedores servicioProvedores = new ServicioProvedoresImpl();
			
		List<Libro> ListaDeLibros = servicioLibros.buscarTodos();
		List<Categoria>ListaDeCategorias = servicioCategorias.buscarTodos();
		List<Provedor>ListaDeProvedores = servicioProvedores.buscarTodos();
			
			request.setAttribute("ListaDeLibros", ListaDeLibros);
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
			request.setAttribute("ListaDeProvedores", ListaDeProvedores);
		
			System.out.println("**************************");
			System.out.println(ListaDeLibros);
			System.out.println(ListaDeCategorias);
			System.out.println(ListaDeProvedores);
			
			return "MostrarLibros.jsp";
			
	}
}
	
