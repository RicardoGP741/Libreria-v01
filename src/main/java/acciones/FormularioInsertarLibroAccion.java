package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import beans.Libro;
import dao.LibroDAO;
import dbHelpers.DataBaseException;

public class FormularioInsertarLibroAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		
		List<Integer> listaDeCategorias=null;
		try {
			listaDeCategorias = new LibroDAO().buscarLasCategorias();
			request.setAttribute("ListaDeCategorias", listaDeCategorias);
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return ("FormularioInsertarLibro.jsp");
	}
}
