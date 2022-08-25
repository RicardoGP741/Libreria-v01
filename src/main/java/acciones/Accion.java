package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dbHelpers.DataBaseException;

public abstract class Accion {
	
	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response) throws DataBaseException;
	

	public static Accion getAccion(String tipo) {
		// TODO Auto-generated method stub
		Accion accion = null;
		
		
		
		try {
			//Se consigue el nombre de la accion
			String text = Accion.class.getPackage()+"."+ tipo+"Accion";
			text = text.substring(8, text.length()); 
			Class c = Class.forName(text);
			accion = (Accion) c.newInstance();
			
		} catch (HibernateException hibernateEx) {
			// TODO Auto-generated catch block
			hibernateEx.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return accion;
	}
	
	public Object getBean(String nombre, HttpServletRequest request) {
		
		WebApplicationContext factoria = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext()); 	
		return factoria.getBean(nombre);
		
	}
}
