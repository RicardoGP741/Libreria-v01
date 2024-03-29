package servicios;

import java.util.List;

import beans.Libro;
import dao.CategoriaDAO;
import dao.LibroDAO;
import dao.ProvedoresDAO;
import dbHelpers.DataBaseException;

public interface ServicioLibros {
	public abstract void insertar (Libro lib);
	public abstract List<Libro> buscarTodos();
	public abstract Libro buscarPorClave(Integer id);
	public abstract void borrar(Libro lib);
	public abstract void guardarCambios(Libro lib);
	public abstract List<Libro> buscarPorCategoria(int cat) throws DataBaseException;

	public LibroDAO getLibroDAO();
	public void setLibroDAO(LibroDAO libroDAO);
}
