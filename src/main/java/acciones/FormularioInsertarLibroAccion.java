package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.Categoria;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

public class FormularioInsertarLibroAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		
		List<Categoria> listaDeCategorias=null;
		try {
			listaDeCategorias = Categoria.buscarCategorias();
			request.setAttribute("ListaDeCategorias", listaDeCategorias);
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return ("FormularioInsertarLibro.jsp");
	}
}
