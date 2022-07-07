package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import beans.Categoria;
import beans.Provedor;
import dbHelpers.DataBaseException;
import dbHelpers.DataBaseHelper;
import dbHelpers.JPAHelper;



public class ProvedoresDAOJPAImpl extends GenericDAOJPAImpl<Provedor, Integer> implements ProvedoresDAO{

	public List<Provedor> buscarProvedores() throws DataBaseException {
		
		String consultaSQL ="SELECT * FROM provedores";
		DataBaseHelper dbh = new DataBaseHelper();
		List <Provedor>ListaDeProvedores=dbh.seleccionarRegistros(consultaSQL, Provedor.class);

		dbh.cerrarObjetos();
		System.out.println("============= ListaDeProvedores =============== \n"+ ListaDeProvedores);
		return ListaDeProvedores;
		
	}

	@Override
	public void insertar(Provedor lib) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Provedor lib) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarCambios(Provedor lib) {
		// TODO Auto-generated method stub
		
	}
}
