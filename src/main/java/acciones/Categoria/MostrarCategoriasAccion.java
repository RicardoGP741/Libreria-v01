package acciones.Categoria;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Categoria;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;


public class MostrarCategoriasAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
	
		System.out.println("Se netra a la MostrarCategoriasAccion");


		//LibroDAOJPAImpl DAOlib = new LibroDAOJPAImpl(); 
		//CategoriaDAOJPAImpl DAOcat = new CategoriaDAOJPAImpl();
		ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
			
		List<Categoria>ListaDeCategorias = servicioCategorias.buscarTodos();
			
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
			System.out.println("**************************");
			System.out.println(ListaDeCategorias);
			return "MostrarCategorias.jsp";
			
	}
}
	
