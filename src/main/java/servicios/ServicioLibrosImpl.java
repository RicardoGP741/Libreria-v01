 package servicios;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Libro;
import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.ProvedoresDAO;
import dbHelpers.DataBaseException;

public class ServicioLibrosImpl implements ServicioLibros {

	private LibroDAO libroDAO=null;


	
	public ServicioLibrosImpl() {

	}
	@Override
	public void insertar(Libro lib) {
		// TODO Auto-generated method stub
		libroDAO.insertar(lib);
	}

	@Override
	public List<Libro> buscarTodos() {
		// TODO Auto-generated method stub
		return libroDAO.buscarTodos();
	}

	@Override
	public Libro buscarPorClave(Integer id) {
		// TODO Auto-generated method stub
		return libroDAO.buscarPorClave(id);
	}

	@Override
	public void borrar(Libro lib) {
		// TODO Auto-generated method stub
		libroDAO.borrar(lib);
	}

	@Override
	public void guardarCambios(Libro lib) {
		// TODO Auto-generated method stub
		libroDAO.guardarCambios(lib);
	}

	@Override
	public List<Libro> buscarPorCategoria(int cat) throws DataBaseException {
		// TODO Auto-generated method stub
		return libroDAO.buscarPorCategoria(cat);
	}
	@Override
	public LibroDAO getLibroDAO() {
		// TODO Auto-generated method stub
		return libroDAO;
	}
	@Override
	public void setLibroDAO(LibroDAO libroDAO) {
		// TODO Auto-generated method stub
		this.libroDAO = libroDAO;
	}


	
}
