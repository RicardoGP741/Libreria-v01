package acciones.Libro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import beans.Libro;
import servicios.ServicioLibros;
import servicios.ServicioLibrosImpl;

public class EditarLibroAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response){
		System.out.println(request.getParameter("idLibro") + request.getParameter("ISBNLibro") + request.getParameter("nomLibro"));
		int id = Integer.parseInt(request.getParameter("idLibro"));
		String StrISBN = request.getParameter("ISBNLibro");
		String StrTitulo = request.getParameter("nomLibro");
		String Cat = request.getParameter("catLibro");
		String Pre = request.getParameter("preLibro");
		String Prov = request.getParameter("provLibro");
	
		ServicioLibros servicioLibros = new ServicioLibrosImpl();
		Libro libro = servicioLibros.buscarPorClave(id);
		libro.setisbn_lib(StrISBN);
		libro.settit_lib(StrTitulo);
		libro.setcat_lib(Integer.parseInt(Cat));
		libro.setpre_lib(Float.parseFloat(Pre));
		libro.setprov_lib(Integer.parseInt(Prov));
		servicioLibros.guardarCambios(libro);
		return "Libro.MostrarLibros.do";
		
		
	}
}
