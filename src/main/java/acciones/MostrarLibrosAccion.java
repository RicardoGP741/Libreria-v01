package acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import beans.Categoria;
import beans.Libro;
import dao.CategoriaDAO;
import dao.CategoriaDAOJPAImpl;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;
import dbHelpers.DataBaseException;
import servicios.ServicioCategorias;
import servicios.ServicioCategoriasImpl;
import servicios.ServicioLibros;
import servicios.ServicioLibrosImpl;

public class MostrarLibrosAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
	
		System.out.println("Se netra a la MostrarLibrosAccion");


		//LibroDAOJPAImpl DAOlib = new LibroDAOJPAImpl(); 
		//CategoriaDAOJPAImpl DAOcat = new CategoriaDAOJPAImpl();
		ServicioLibros servicioLibros = new ServicioLibrosImpl();
		ServicioCategorias servicioCategorias = new ServicioCategoriasImpl();
			
		List<Libro> ListaDeLibros = servicioLibros.buscarTodos();
		List<Integer>ListaDeCategorias = servicioCategorias.buscarLasCategorias();
			
			request.setAttribute("ListaDeLibros", ListaDeLibros);
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
		
			return "MostrarLibros.jsp";
			
	}
}
	
