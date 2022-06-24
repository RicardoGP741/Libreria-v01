package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import beans.Libro;
import dbHelpers.DataBaseException;
import dbHelpers.HibernateHelper;
import dbHelpers.JPAHelper;

public class LibroDAO {
	
	public static List<Integer> buscarLasCategorias() throws DataBaseException{
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Integer>consulta = manager.createQuery("SELECT DISTINCT libros.cat_lib FROM Libro libros", Integer.class);
		List<Integer> ListaDecat_libs = consulta.getResultList();
		manager.close();
		return ListaDecat_libs;
	}
	
	public void insertar (Libro lib){
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		try {
			
		} catch(Exception e) {
			e.getStackTrace();
		}
		
	}
	
	public static List<Libro> buscarTodos(){
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Libro>consulta = manager.createQuery("SELECT l FROM Libro l JOIN FETCH l.categoria", Libro.class);
		List<Libro> ListaDeLibros = consulta.getResultList();
		manager.close();
		return ListaDeLibros;
	}
	
	
	public Libro buscarLibro(int id) {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Libro>consulta = manager.createQuery("SELECT l FROM Libro l JOIN FETCH l.categoria WHERE l.num_lib=?1", Libro.class);
		consulta.setParameter(1, id);
		Libro libro = consulta.getSingleResult();
		manager.close();
		return libro;
	}
			
	
	public void BorrarLibro(Libro lib){
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		tx = manager.getTransaction();
		tx.begin();
		manager.remove(manager.merge(this));
		tx.commit();
		manager.close();
	}
	
	public void GuardarCambios(Libro lib) {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		tx = manager.getTransaction();
		tx.begin();
		manager.merge(this);
		tx.commit();
		manager.close();
	}
	
	public static List<Libro> buscarPorCategoria(int cat){
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Libro>consulta = manager.createQuery("SELECT l FROM Libro l WHERE l.cat_lib=?1", Libro.class);
		consulta.setParameter(1, cat);
		List<Libro> ListaDeLibros = consulta.getResultList();
		manager.close();
		return ListaDeLibros;
		
	}
}
