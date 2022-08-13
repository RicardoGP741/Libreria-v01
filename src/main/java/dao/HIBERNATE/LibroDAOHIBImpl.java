package dao.HIBERNATE;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import beans.Libro;
import dao.LibroDAO;
import dbHelpers.HibernateHelper;


public class LibroDAOHIBImpl extends GenericDAOHIBImpl<Libro, Integer> implements LibroDAO{
	
	
	
	
	public List<Libro> buscarPorCategoria(int cat){
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Query consulta = session.createQuery("FROM Libro libro WHERE libro.cat_lib ="+cat);
		List<Libro> ListaDeLibros = consulta.list();
		session.close();
		return ListaDeLibros;		
	}

}
