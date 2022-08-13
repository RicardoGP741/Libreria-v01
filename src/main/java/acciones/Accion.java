package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import dbHelpers.DataBaseException;

public abstract class Accion {
	
	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response) throws DataBaseException;
	

	public static Accion getAccion(String tipo) {
		// TODO Auto-generated method stub
		Accion accion = null;
		
		
		
		try {
			System.out.println("Este es el tipo:   " + tipo);
			String text = Accion.class.getPackage()+"."+ tipo+"Accion";
			System.out.println("Asi queda el accion text:  " + text);
			text = text.substring(8, text.length()); //acciones.MostrarLibrosAccion < debe quedar asi
			System.out.println("Asi queda el accion text:  " + text);
			System.out.println(text);
			Class c = Class.forName(text);
			System.out.println("Clase: " + c); 
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
}
