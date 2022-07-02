package dao;

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
import dbHelpers.DataBaseException;
import dbHelpers.HibernateHelper;
import dbHelpers.JPAHelper;

public class LibroDAOJPAImpl extends GenericDAOJPAImpl<Libro, Integer> implements LibroDAO{
	
	
	
	
	public List<Libro> buscarPorCategoria(int cat){
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Libro>consulta = manager.createQuery("SELECT l FROM Libro l WHERE l.cat_lib=?1", Libro.class);
		consulta.setParameter(1, cat);
		List<Libro> ListaDeLibros = consulta.getResultList();
		manager.close();
		return ListaDeLibros;
		
	}

	@Override
	public List<Integer> buscarLasCategorias() {
		// TODO Auto-generated method stub
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Integer>consulta = manager.createQuery("SELECT DISTINCT libro.cat_lib FROM Libro libro", Integer.class);
		List<Integer> ListaDeCategorias = consulta.getResultList();
		manager.close();
		return ListaDeCategorias;
	}

}
