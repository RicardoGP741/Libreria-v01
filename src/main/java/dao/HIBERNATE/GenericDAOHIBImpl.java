package dao.HIBERNATE;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.GenericDAO;
import dbHelpers.HibernateHelper;

public abstract class GenericDAOHIBImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

	private Class<T> claseDePersistencia;
	
	
	@SuppressWarnings("unchecked")
	public GenericDAOHIBImpl() {
		System.out.println("En generic DAO Implements: ");
		this.claseDePersistencia = (Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T buscarPorClave(Id id) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		T objeto = (T)session.get(claseDePersistencia, id);
		session.close();
		return objeto;
	}
	
	public List<T> buscarTodos(){
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		List<T>ListaDeObjetos = session.createQuery("SELECT o FROM "+claseDePersistencia.getSimpleName()+ " o", claseDePersistencia).list();
		session.close();
		return ListaDeObjetos;
	}
	
	public void borrar(T objeto) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.delete(this);
		session.getTransaction().commit();
		session.close();
	}
	
	public void insertar(T objeto) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
		session.close();
	}
	
	public void guardarCambios(T objeto) {

	}
	
}
