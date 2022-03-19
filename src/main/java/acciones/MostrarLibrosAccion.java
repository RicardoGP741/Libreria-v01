package acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.Categoria;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

public class MostrarLibrosAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
	
		System.out.println("Se netra a la MostrarLibrosAccion");
		//accion = new MostrarLibrosAccion();
		
		/*
		List<Libro>ListaDeLibros = null;
		List<Libro>ListaPorCategorias = null;
		try {
			System.out.println(""+response.getWriter().append("Served at: ").append(request.getContextPath()));
			System.out.println("ACABA DE ENTRAR AL SERVLET");
			if(request.getParameter("categoria")==null|| request.getParameter("categoria").equals("Seleccionar")) {
				System.out.println("PARAMETRO: "+request.getParameter("categoria"));
				ListaDeLibros= Libro.();
			}else {
				int cat = Integer.parseInt(request.getParameter("categoria"));
				ListaPorCategorias=Libro.buscarPorCategoria(cat);
			}
			
			
			//ListaPorCategorias= Libro.buscarPorCategoria(1);
			List<Categoria>ListaDeCategorias= Categoria.buscarCategorias();
			
			
				
			
			request.setAttribute("ListaDeLibros", ListaDeLibros);
			request.setAttribute("ListaDeCategorias", ListaDeCategorias);
			request.setAttribute("ListaPorCategoria", ListaPorCategorias);
			
			
			
			
		} catch (DataBaseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		//getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		
		List<Libro>ListaDeLibros = null;
		List<Integer>ListaPorCategorias = null;
		try {
			
			ListaDeLibros =Libro.buscarTodos();
			ListaPorCategorias = Libro.buscarLasCategorias();
			
			
			request.setAttribute("ListaDeLibros", ListaDeLibros);
			request.setAttribute("ListaPorCategorias", ListaPorCategorias); }
			catch (DataBaseException e) {
				e.printStackTrace();
			} 
		return "MostrarLibros.jsp";
	}
}
