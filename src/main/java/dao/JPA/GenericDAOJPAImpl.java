package dao.JPA;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import dao.GenericDAO;
import dbHelpers.JPAHelper;

public abstract class GenericDAOJPAImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

	private Class<T> claseDePersistencia;
	
	EntityManagerFactory entityManagerFactory;
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl() {
		System.out.println("En generic DAO Implements JPA: ");
		this.claseDePersistencia = (Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T buscarPorClave(Id id) {

		EntityManager manager = entityManagerFactory.createEntityManager();
		T objeto = null;
		try {
			objeto = (T) manager.find(claseDePersistencia, id);
			
		} catch(PersistenceException e){
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return objeto;
	}
	
	public List<T> buscarTodos(){
		TypedQuery<T> consulta = null;
		EntityManager manager = entityManagerFactory.createEntityManager();
		try {
			consulta = manager.createQuery("SELECT o FROM "+claseDePersistencia.getSimpleName()+ " o", claseDePersistencia);
			System.out.println("===============================");
			System.out.println(consulta.getResultList());
			System.out.println("===============================");
		} catch(PersistenceException e){
			e.printStackTrace();
		}
		return consulta.getResultList();
	}
	
	public void borrar(T objeto) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = null;
		System.out.println("EN BORRAR ->>>  |||| " + objeto);
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.remove(manager.merge(objeto));
			tx.commit();
			manager.close();
			
		} catch(PersistenceException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			manager.close();
		}
	}
	
	public void insertar(T objeto) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = null;
		
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(objeto);
			tx.commit();
			
		} catch(PersistenceException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			manager.close();
		}
	}
	
	public void guardarCambios(T objeto) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = null;
		
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.merge(objeto);
			tx.commit();
			
		} catch(PersistenceException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			manager.close();
		}
	}
	
	
}
