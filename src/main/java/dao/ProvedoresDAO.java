package dao;

import java.util.List;

import beans.Provedor;
import dbHelpers.DataBaseException;

public interface ProvedoresDAO {
	public abstract void insertar (Provedor lib);
	public abstract List<Provedor> buscarTodos();
	public abstract void borrar(Provedor lib);
	public abstract void guardarCambios(Provedor lib);
	public abstract List<Provedor> buscarProvedores() throws DataBaseException;
	public abstract Provedor buscarPorClave(Integer id);
}
