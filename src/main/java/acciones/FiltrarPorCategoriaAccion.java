package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import beans.Libro;
import dao.LibroDAO;
import dbHelpers.DataBaseException;

public class FiltrarPorCategoriaAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){


		int C = Integer.parseInt(request.getParameter("categoria"));
		List<Libro>ListaDeLibros;
		List<Integer>ListaDeCategorias;
		try {
			
			ListaDeLibros = new LibroDAO().buscarPorCategoria(C);
			ListaDeCategorias = new LibroDAO().buscarLasCategorias();
			
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
