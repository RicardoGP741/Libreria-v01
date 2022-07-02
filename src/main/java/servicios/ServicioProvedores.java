package servicios;

import java.util.List;
import beans.Categoria;


public interface ServicioProvedores {
	public abstract void insertar (Categoria lib);
	public abstract List<Categoria> buscarTodos();
	public abstract void borrar(Categoria lib);
	public abstract void guardarCambios(Categoria lib);
	public abstract List<Integer> buscarLasCategorias();
}
