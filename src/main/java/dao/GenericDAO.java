package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

public interface GenericDAO<T, Id extends Serializable> {
	T buscarPorClave(Id id);
	List<T> buscarTodos();
	void borrar(T objeto);
	void insertar(T objeto);
	void guardarCambios(T objeto);
	
}
