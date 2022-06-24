package acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import beans.Categoria;
import beans.Libro;
import dao.LibroDAO;
import dbHelpers.DataBaseException;

public class MostrarLibrosAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
	
		System.out.println("Se netra a la MostrarLibrosAccion");

		List<Libro>ListaDeLibros;
		List<Integer>ListaDeCategorias;
		LibroDAO DAOlib = new LibroDAO(); 
		try {
			
			ListaDeLibros = DAOlib.buscarTodos();
			ListaDeCategorias = DAOlib.buscarLasCategorias();
			
			request.setAttribute("ListaDeLibros", ListaDeLibros);
			request.setAttribute("ListaDeCategorias", ListaDeLibros);
		}
			//request.setAttribute("ListaPorCategorias", ListaPorCategorias); }
		catch (DataBaseException e1) {
				e1.printStackTrace();
			}
		return "MostrarLibros.jsp";
	}
}
