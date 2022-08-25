package servicios;

import java.util.List;

import beans.Categoria;
import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dbHelpers.DataBaseException;

public class ServicioCategoriasImpl implements ServicioCategorias {

	private CategoriaDAO categoriaDAO=null;
	
	public ServicioCategoriasImpl() {

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
		categoriaDAO.borrar(cat);;
	}

	@Override
	public void guardarCambios(Categoria cat) {
		// TODO Auto-generated method stub
		categoriaDAO.guardarCambios(cat);
	}

	@Override
	public List<Categoria> buscarLasCategorias() throws DataBaseException {
		// TODO Auto-generated method stub
		return categoriaDAO.buscarLasCategorias();
	}

	@Override
	public Categoria buscarPorClave(Integer id) {
		// TODO Auto-generated method stub
		return categoriaDAO.buscarPorClave(id);
	}
	
	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return categoriaDAO;
	}
	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		// TODO Auto-generated method stub
		this.categoriaDAO = categoriaDAO;
	}
	
}
