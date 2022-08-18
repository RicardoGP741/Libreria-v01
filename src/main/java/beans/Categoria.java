package beans;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")

public class Categoria {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id_cat;
	@Column
	private String nom_cat;
	@OneToMany(cascade = CascadeType.MERGE,mappedBy="categoria")
	private List<Libro> listaDeLibros;
	
	public Categoria(String nombre) {
		nom_cat = nombre;
	}
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
	
	public String toString() {
		return this.id_cat+"\t\t"+this.nom_cat;
	}



	
	
	
}
