package dao.HIBERNATE;

import dao.CategoriaDAO;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.ProvedoresDAO;

public class DAOHIBFactory implements DAOFactory{
	public CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAOHIBImpl();
	}
	public LibroDAO getLibroDAO() {
		return new LibroDAOHIBImpl(); 
	}
	@Override
	public ProvedoresDAO getProvedorDAO() {
		// TODO Auto-generated method stub
		return new ProvedoresDAOHIBImpl();
	}
}
 