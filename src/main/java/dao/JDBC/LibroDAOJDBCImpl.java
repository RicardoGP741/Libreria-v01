package dao.JDBC;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import beans.Libro;
import dao.LibroDAO;
import dbHelpers.DataBaseException;
import dbHelpers.DataBaseHelper;
import dbHelpers.HibernateHelper;
import dbHelpers.JPAHelper;

public class LibroDAOJDBCImpl extends GenericDAOJDBCImpl<Libro, Integer> implements LibroDAO{
	
	
	
	
	public List<Libro> buscarPorCategoria(int cat) throws DataBaseException{
		String SQL ="SELECT * FROM libros WHERE cat_lib="+cat;
		DataBaseHelper dbh = new DataBaseHelper();
		List<Libro>ListaDeLibros = dbh.seleccionarRegistros(SQL, Libro.class);
		dbh.cerrarObjetos();
		return ListaDeLibros;
		
	}

}
