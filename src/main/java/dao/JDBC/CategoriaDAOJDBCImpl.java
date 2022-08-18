package dao.JDBC;

import java.util.List;

import beans.Categoria;
import dao.CategoriaDAO;
import dbHelpers.DataBaseException;
import dbHelpers.DataBaseHelper;



public class CategoriaDAOJDBCImpl extends GenericDAOJDBCImpl<Categoria, Integer> implements CategoriaDAO{

	public List<Categoria> buscarLasCategorias() throws DataBaseException{
		
		String consultaSQL="SELECT * FROM categorias";
		DataBaseHelper dbh = new DataBaseHelper();
		List<Categoria> ListaDeCategorias = dbh.seleccionarRegistros(consultaSQL, Categoria.class);
		dbh.cerrarObjetos();
		return ListaDeCategorias;
	}

}
