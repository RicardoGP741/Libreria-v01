package dao.HIBERNATE;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Categoria;
import beans.Provedor;
import dao.ProvedoresDAO;
import dbHelpers.DataBaseException;
import dbHelpers.DataBaseHelper;
import dbHelpers.HibernateHelper;
import dbHelpers.JPAHelper;



public class ProvedoresDAOHIBImpl extends GenericDAOHIBImpl<Provedor, Integer> implements ProvedoresDAO{

	public List<Provedor> buscarProvedores() throws DataBaseException {	
		
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		String consulta = "SELECT nom_prov FROM provedores";
		List<Provedor> ListaDeProvedores = session.createQuery(consulta).list();
		session.close();
		return ListaDeProvedores;
		
	}

}
