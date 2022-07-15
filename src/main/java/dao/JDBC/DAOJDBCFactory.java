package dao.JDBC;

import dao.CategoriaDAO;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.ProvedoresDAO;

public class DAOJDBCFactory implements DAOFactory{
	public CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAOJDBCImpl();
	}
	public LibroDAO getLibroDAO() {
		return new LibroDAOJDBCImpl(); 
	}
	@Override
	public ProvedoresDAO getProvedorDAO() {
		// TODO Auto-generated method stub
		return new ProvedoresDAOJDBCImpl();
	}
}
 