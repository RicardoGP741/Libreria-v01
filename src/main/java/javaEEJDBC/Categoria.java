package javaEEJDBC;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "categorias")

public class Categoria {
	@Id
	@Column(name = "id_cat")
	private int id_cat;
	private String nom_cat;
	@Fetch(value = FetchMode.SELECT)
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cat")
	private List<Libro> listaDeLibros;
	
	public Categoria() {
	}
	public List<Libro> getListaDeLibros() {
		return listaDeLibros;
	}

	public void setListaDeLibros(List<Libro> listaDeLibros) {
		this.listaDeLibros = listaDeLibros;
	}
	public int getid_cat() {
		return id_cat;
	}

	public void setid_cat(int id_cat) {
		this.id_cat = id_cat;
	}

	public String getnom_cat() {
		return nom_cat;
	}

	public void setnom_cat(String nom_cat) {
		this.nom_cat = nom_cat;
	}



	//CAMBIAR LOS ARRAYLIST POR LIST (SOLO LO PRIMERO Y EL RETORNO)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Categoria> buscarCategorias() throws DataBaseException {
		String consultaSQL="SELECT * FROM categorias";
		DataBaseHelper dbh = new DataBaseHelper();
		List <Categoria>ListaDeCategorias=dbh.seleccionarRegistros(consultaSQL, Categoria.class);
		
		
		dbh.cerrarObjetos();
		return ListaDeCategorias;
	}
	
	
	
}
