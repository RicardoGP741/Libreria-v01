package servicios;

import java.util.List;
import beans.Categoria;
import beans.Provedor;
import dbHelpers.DataBaseException;


public interface ServicioProvedores {
	public abstract void insertar (Provedor lib);
	public abstract List<Provedor> buscarTodos();
	public abstract void borrar(Provedor lib);
	public abstract void guardarCambios(Provedor lib);
	public abstract List<Provedor> buscarProvedores() throws DataBaseException;
}
