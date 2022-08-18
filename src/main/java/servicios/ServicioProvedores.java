package servicios;

import java.util.List;

import beans.Provedor;
import dbHelpers.DataBaseException;


public interface ServicioProvedores {
	public abstract void insertar (Provedor prov);
	public abstract List<Provedor> buscarTodos();
	public abstract void borrar(Provedor prov);
	public abstract void guardarCambios(Provedor prov);
	public abstract List<Provedor> buscarProvedores() throws DataBaseException;
	public abstract Provedor buscarPorClave(int id);
}
