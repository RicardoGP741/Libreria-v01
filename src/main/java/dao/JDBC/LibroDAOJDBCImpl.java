package dao.JDBC;
import java.util.List;

import beans.Libro;
import dao.LibroDAO;
import dbHelpers.DataBaseException;
import dbHelpers.DataBaseHelper;

public class LibroDAOJDBCImpl extends GenericDAOJDBCImpl<Libro, Integer> implements LibroDAO{
	
	
	
	
	public List<Libro> buscarPorCategoria(int cat) throws DataBaseException{
		String SQL ="SELECT * FROM libros WHERE cat_lib="+cat;
		DataBaseHelper dbh = new DataBaseHelper();
		List<Libro>ListaDeLibros = dbh.seleccionarRegistros(SQL, Libro.class);
		dbh.cerrarObjetos();
		return ListaDeLibros;
		
	}

}
