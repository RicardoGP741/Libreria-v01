package servicios;

import java.util.List;

import beans.Categoria;
import dao.CategoriaDAO;
import dbHelpers.DataBaseException;


public interface ServicioCategorias {
	public abstract void insertar (Categoria lib);
	public abstract List<Categoria> buscarTodos();
	public abstract void borrar(Categoria lib);
	public abstract void guardarCambios(Categoria lib);
	public abstract List<Categoria> buscarLasCategorias() throws DataBaseException;
	public abstract Categoria buscarPorClave(Integer id);
	
	public CategoriaDAO getCategoriaDAO();
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
}
