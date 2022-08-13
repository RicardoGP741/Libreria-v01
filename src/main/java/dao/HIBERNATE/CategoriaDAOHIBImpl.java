package dao.HIBERNATE;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Categoria;
import dao.CategoriaDAO;
import dbHelpers.DataBaseException;
import dbHelpers.HibernateHelper;
import dbHelpers.JPAHelper;



public class CategoriaDAOHIBImpl extends GenericDAOHIBImpl<Categoria, Integer> implements CategoriaDAO{

	public List<Categoria> buscarLasCategorias(){
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		String consulta = "SELECT DISTINCT libro.cat_lib from Libro libro";
		List<Categoria> ListaDecat_libs = session.createQuery(consulta).list();
		session.close();
		return ListaDecat_libs;
	}

}
