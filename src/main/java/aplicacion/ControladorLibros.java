package aplicacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import acciones.Libro.MostrarLibrosAccion;
import dbHelpers.DataBaseException;

/**
 * Servlet implementation class ControladorLibros
 */
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

		Accion accion = null;
		RequestDispatcher despachador = null;
		String url = request.getServletPath();
		
		if(request.getServletPath().equals("/ControladorLibros.do"))   
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
	}
}
