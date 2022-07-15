package acciones.Provedor;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Provedor;
import servicios.ServicioProvedores;
import servicios.ServicioProvedoresImpl;


public class MostrarProvedoresAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
	
		System.out.println("Se netra a la MostrarCategoriasAccion");


		//LibroDAOJPAImpl DAOlib = new LibroDAOJPAImpl(); 
		//CategoriaDAOJPAImpl DAOcat = new CategoriaDAOJPAImpl();
		ServicioProvedores servicioProvedores = new ServicioProvedoresImpl();
			
		List<Provedor>ListaDeProvedores = servicioProvedores.buscarTodos();
			
			request.setAttribute("ListaDeProvedores", ListaDeProvedores);
			System.out.println("**************************");
			System.out.println(ListaDeProvedores);
			return "MostrarProvedores.jsp";
			
	}
}
	
