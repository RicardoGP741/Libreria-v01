package dao.JDBC;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import beans.Categoria;
import dao.CategoriaDAO;
import dbHelpers.DataBaseException;
import dbHelpers.DataBaseHelper;
import dbHelpers.JPAHelper;



public class CategoriaDAOJDBCImpl extends GenericDAOJDBCImpl<Categoria, Integer> implements CategoriaDAO{

	public List<Categoria> buscarLasCategorias() throws DataBaseException{
		
		String consultaSQL="SELECT * FROM categorias";
		DataBaseHelper dbh = new DataBaseHelper();
		List<Categoria> ListaDeCategorias = dbh.seleccionarRegistros(consultaSQL, Categoria.class);
		dbh.cerrarObjetos();
		return ListaDeCategorias;
	}

}
