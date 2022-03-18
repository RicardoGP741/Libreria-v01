package aplicacion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import acciones.BorrarLibroAccion;
import acciones.EditarLibroAccion;
import acciones.FiltrarPorCategoriaAccion;
import acciones.FormularioInsertarLibroAccion;
import acciones.InsertarLibroAccion;
import acciones.MostrarLibrosAccion;
import javaEEJDBC.Categoria;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

/**
 * Servlet implementation class ControladorLibros
 */
//@WebServlet("/ControladorLibros")// ESTOS SON ANOTACIONES
public class ControladorLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLibros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		System.out.println("=======================");
		Accion accion = null;
		RequestDispatcher despachador = null;
		String url = request.getServletPath();
		accion = Accion.getAccion(url.substring(1, url.length()-3));
		System.out.println("Pasando por get Accion");
		System.out.println("=======================");
		/*
		if(request.getServletPath().equals("/ControladorLibros.do")){
			if(request.getParameter("categoria").equals("Seleccionar")) {
				accion = new MostrarLibrosAccion();
			}
			else {
				accion = new FiltrarPorCategoriaAccion();
			}
		} */
			
		
		
		if(request.getServletPath().equals("/MostrarLibros.do"))   //SACA EL ORIGEN DE DONDE SE LLAMO Y LO COMPARA CON MSOTRAR LIBRO
		{
			
			//accion = new MostrarLibrosAccion();
			System.out.println(""+response.getWriter().append("Served at: ").append(request.getContextPath()));
			System.out.println("ACABA DE ENTRAR AL SERVLET");
			
			List<Libro>ListaDeLibros = null;
			List<Libro>ListaPorCategorias = null;
			try {
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
			}
			despachador=request.getRequestDispatcher("MostrarLibros.jsp");
			despachador.forward(request, response);
			//getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
				
		}
		else if(request.getServletPath().equals("/ControladorLibros.do")) 
		{
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
			}
		} 
		if (accion!= null) {
			despachador=request.getRequestDispatcher(accion.ejecutar(request, response));
			despachador.forward(request, response);
		}	
		
	}
}
