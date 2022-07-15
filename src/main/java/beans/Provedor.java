package beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import dbHelpers.DataBaseException;
import dbHelpers.DataBaseHelper;

@Entity
@Table(name = "provedores")
public class Provedor {
	@Id
	@PrimaryKeyJoinColumn
	private int id_prov;
	@Column
	private String nom_prov;
	@OneToMany(cascade = CascadeType.MERGE,mappedBy="provedor")
	private List<Libro> listaDeLibros;

	public Provedor() {
	}
	
	public Provedor(String nombre) {
		nom_prov = nombre;
	}
	
	public List<Libro> getListaDeLibros() {
		return listaDeLibros;
	}

	public void setListaDeLibros(List<Libro> listaDeLibros) {
		this.listaDeLibros = listaDeLibros;
	}

	public int getid_prov() {
		return id_prov;
	}

	public void setid_prov(int id_prov) {
		this.id_prov = id_prov;
	}

	public String getnom_prov() {
		return nom_prov;
	}

	public void setnom_prov(String nom_prov) {
		this.nom_prov = nom_prov;
	}

	public String toString() {
		return this.id_prov+"\t\t"+this.nom_prov;
	}
}
