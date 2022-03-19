package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.Categoria;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

public class FiltrarPorCategoriaAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		/*
		//accion = new FiltrarPorCategoriaAccion();
		try {
			List<Libro>ListaPorCategorias = null;
			List<Libro>ListaDeLibros = null;
			if(request.getParameter("categoria")==null|| request.getParameter("categoria").equals("Seleccionar")) {
				System.out.println("PARAMETRO: "+request.getParameter("categoria"));
				ListaDeLibros= Libro.buscarTodos();
			}else {
				int cat = Integer.parseInt(request.getParameter("categoria"));
				ListaPorCategorias=Libro.buscarPorCategoria(cat);
			}
			
			
			//ListaPorCategorias= Libro.buscarPorCategoria(1);
			List<Categoria>ListaDeCategorias= Categoria.buscarCategorias();
			
		 	request.setAttribute("ListaDeLibros", ListaDeLibros);
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
			request.setAttribute("ListaPorCategoria", ListaPorCategorias);
			
			
			
			
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		
		int C = Integer.parseInt(request.getParameter("categoria"));
		List<Libro> listaDeLibros;
		List<Integer> listaDeCategorias;
		System.out.println("aqui");
		try {
			new Libro();
			listaDeLibros = Libro.buscarPorCategoria(C);
			listaDeCategorias = Libro.buscarLasCategorias();
			
			request.setAttribute("listaDeLibros", listaDeLibros);
			request.setAttribute("listaDeCategorias", listaDeCategorias); 
		} catch (DataBaseException e) {
			e.printStackTrace();
		} 
		return "MostrarLibros.jsp";
	}
}
