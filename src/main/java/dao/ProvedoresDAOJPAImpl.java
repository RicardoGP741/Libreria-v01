package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import beans.Categoria;
import dbHelpers.DataBaseException;
import dbHelpers.JPAHelper;



public class ProvedoresDAOJPAImpl extends GenericDAOJPAImpl<Categoria, Integer> implements CategoriaDAO{

	public List<Integer> buscarLasCategorias(){
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Integer>consulta = manager.createQuery("SELECT DISTINCT libro.cat_lib FROM Libro libro", Integer.class);
		List<Integer> ListaDeCategorias = consulta.getResultList();
		manager.close();
		return ListaDeCategorias;
	}

}
