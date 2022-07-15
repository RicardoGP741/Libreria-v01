package dao.HIBERNATE;

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

public abstract class GenericDAOHIBImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

	private Class<T> claseDePersistencia;
	
	
	@SuppressWarnings("unchecked")
	public GenericDAOHIBImpl() {
		System.out.println("En generic DAO Implements: ");
		this.claseDePersistencia = (Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T buscarPorClave(Id id) {
		return null;
	}
	
	public List<T> buscarTodos(){
		return null;
	}
	
	public void borrar(T objeto) {

	}
	
	public void insertar(T objeto) {

	}
	
	public void guardarCambios(T objeto) {

	}
	
	
}
