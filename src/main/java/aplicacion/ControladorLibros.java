package aplicacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import acciones.Accion;
import acciones.Categoria.FiltrarPorCategoriaAccion;
import acciones.Libro.MostrarLibrosAccion;
import dbHelpers.DataBaseException;

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
		/*
		System.out.println("=======================");
		String url = request.getServletPath();
		RequestDispatcher despachador = null;
		Accion accion = null;
		
		System.out.println("URL" + url);
		System.out.println("====:===================");
		*/
		
		Accion accion = null;
		RequestDispatcher despachador = null;
		String url = request.getServletPath();
		System.out.println("Este es el url del controlador:  " + url);
		System.out.println("Pasando por get Accion");
		System.out.println("=======================");
		
		if(request.getServletPath().equals("/ControladorLibros.do"))   //SACA EL ORIGEN DE DONDE SE LLAMO Y LO COMPARA CON MSOTRAR LIBRO
		{
			/*if(request.getParameter("categoria").equals("seleccionar")) {
				accion = new MostrarLibrosAccion();
			} else {
				accion = new FiltrarPorCategoriaAccion();
			}*/
			accion = new MostrarLibrosAccion();
		}	
		else {
			accion = Accion.getAccion(url.substring(1, url.length()-3));
		}
		if (accion!= null) {
			try {
				despachador=request.getRequestDispatcher(accion.ejecutar(request, response));
			} catch (DataBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			despachador.forward(request, response);
		}	
		
		
		/*
		if(request.getServletPath().equals("/ControladorLibros.do")){
			if(request.getParameter("categoria").equals("Seleccionar")) {
				accion = new MostrarLibrosAccion();
			}
			else {
				accion = new FiltrarPorCategoriaAccion();
			}
		} */
			
		
		
		
		
	}
}
