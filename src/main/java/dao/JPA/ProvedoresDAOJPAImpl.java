package dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import beans.Categoria;
import beans.Provedor;
import dao.ProvedoresDAO;
import dbHelpers.DataBaseException;
import dbHelpers.DataBaseHelper;
import dbHelpers.JPAHelper;



public class ProvedoresDAOJPAImpl extends GenericDAOJPAImpl<Provedor, Integer> implements ProvedoresDAO{

	public List<Provedor> buscarProvedores() throws DataBaseException {
		
		String consultaSQL ="SELECT * FROM provedores";
		DataBaseHelper dbh = new DataBaseHelper();
		List <Provedor>ListaDeProvedores=dbh.seleccionarRegistros(consultaSQL, Provedor.class);

		dbh.cerrarObjetos();
		return ListaDeProvedores;
		
	}

}
