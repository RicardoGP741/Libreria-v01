package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.HibernateHelper;
import javaEEJDBC.Libro;

public class EditarLibroAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		System.out.println(request.getParameter("idLibro") + request.getParameter("ISBNLibro") + request.getParameter("nomLibro"));
		int id = Integer.parseInt(request.getParameter("idLibro"));
		String StrISBN = request.getParameter("ISBNLibro");
		String StrTitulo = request.getParameter("nomLibro");
		String Cat = request.getParameter("catLibro");
		String Pre = request.getParameter("preLibro");
		
		
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Libro libro = (Libro) session.find(Libro.class, id);
		libro.setisbn_lib(StrISBN);
		libro.settit_lib(StrTitulo);
		libro.setcat_lib(Integer.parseInt(Cat));
		libro.setpre_lib(Float.parseFloat(Pre));
		libro.insertar();
		session.close();
		
		
	return ("MostrarLibros.do");
	}
}
