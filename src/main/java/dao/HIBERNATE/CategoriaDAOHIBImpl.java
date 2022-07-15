package dao.HIBERNATE;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import beans.Categoria;
import dao.CategoriaDAO;
import dbHelpers.DataBaseException;
import dbHelpers.JPAHelper;



public class CategoriaDAOHIBImpl extends GenericDAOHIBImpl<Categoria, Integer> implements CategoriaDAO{

	public List<Categoria> buscarLasCategorias(){
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Categoria>consulta = manager.createQuery("SELECT DISTINCT libro.cat_lib FROM Libro libro", Categoria.class);
		List<Categoria> ListaDeCategorias = consulta.getResultList();
		manager.close();
		return ListaDeCategorias;
	}

}
