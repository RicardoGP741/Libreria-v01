package servicios;

import java.util.List;

import beans.Categoria;  
import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;

public class ServicioCategoriasImpl implements ServicioCategorias {

	private CategoriaDAO categoriaDAO=null;
	
	public ServicioCategoriasImpl() {
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		categoriaDAO = factoria.getCategoriaDAO();
	}

	@Override
	public void insertar(Categoria cat) {
		// TODO Auto-generated method stub
		categoriaDAO.insertar(cat);
	}

	@Override
	public List<Categoria> buscarTodos() {
		return categoriaDAO.buscarTodos();
	}

	@Override
	public void borrar(Categoria cat) {
		// TODO Auto-generated method stub
		categoriaDAO.insertar(cat);
	}

	@Override
	public void guardarCambios(Categoria cat) {
		// TODO Auto-generated method stub
		categoriaDAO.guardarCambios(cat);
	}

	@Override
	public List<Integer> buscarLasCategorias() {
		// TODO Auto-generated method stub
		return categoriaDAO.buscarLasCategorias();
	}
	
	
}
