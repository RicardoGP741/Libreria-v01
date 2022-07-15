package dao.JPA;

import dao.CategoriaDAO;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.ProvedoresDAO;

public class DAOJPAFactory implements DAOFactory{
	public CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAOJPAImpl();
	}
	public LibroDAO getLibroDAO() {
		return new LibroDAOJPAImpl(); 
	}
	@Override
	public ProvedoresDAO getProvedorDAO() {
		// TODO Auto-generated method stub
		return new ProvedoresDAOJPAImpl();
	}
}
 