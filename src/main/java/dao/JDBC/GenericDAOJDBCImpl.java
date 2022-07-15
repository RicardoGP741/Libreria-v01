package dao.JDBC;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import beans.Libro;
import dao.GenericDAO;
import dbHelpers.DataBaseException;
import dbHelpers.DataBaseHelper;
import dbHelpers.JPAHelper;

public abstract class GenericDAOJDBCImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

	private Class<T> claseDePersistencia;
	
	
	@SuppressWarnings("unchecked")
	public GenericDAOJDBCImpl() {
		System.out.println("En generic DAO Implements: ");
		this.claseDePersistencia = (Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T buscarPorClave(Id id) {
		String SQL ="SELECT * FROM libros WHERE num_lib="+id;
		DataBaseHelper dbh = null;
		T objeto = null;
		try {
			dbh = new DataBaseHelper();
			objeto = (T) dbh.seleccionarRegistros(SQL, Libro.class);
			dbh.cerrarObjetos();
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  objeto;
	}
	
	public List<T> buscarTodos(){
		TypedQuery<T> consulta = null;
		try {
			String SQL ="SELECT * FROM libros";
			DataBaseHelper  dbh = new DataBaseHelper();
			consulta = (TypedQuery<T>) dbh.seleccionarRegistros(SQL, Libro.class);
			dbh.cerrarObjetos();
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (List<T>) consulta;
	}
	
	public void borrar(T objeto) {
		try {
			String SQL ="DELETE  FROM libros WHERE num_lib="+objeto+";";
			DataBaseHelper dbh = new DataBaseHelper();
			int filas=dbh.modificarRegistro(SQL);
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertar(T objeto) {
		/*
		String consultaSQL="INSERT INTO libros(isbn_lib,tit_lib,cat_lib,pre_lib) VALUES ";
		consultaSQL +="('"+isbn_lib+"','"+tit_lib+"',"+cat_lib+","+pre_lib+");";
		DataBaseHelper dbh = new DataBaseHelper();
		int filasModif=dbh.modificarRegistro(consultaSQL);
		dbh.cerrarObjetos();*/
	}
	
	public void guardarCambios(T objeto) {
		/*
		try {
			DataBaseHelper dbh = new DataBaseHelper();
			int filasModif=dbh.actualizarRegistro(objeto, this);
			dbh.cerrarObjetos();
			System.out.println("FILAS MODIFICADAS: "+filasModif);
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
}
