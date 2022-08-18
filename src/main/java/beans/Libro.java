package beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "libros")
public class Libro {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_lib;
	@Column
	private String isbn_lib;
	@Column
	private String tit_lib;
	@Column
	private float pre_lib;
	@Column
	private int cat_lib;
	@Column
	private int prov_lib;

	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = Categoria.class)
    @JoinColumn(name = "cat_lib", updatable=false, insertable=false)
	private Categoria categoria;
	
	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = Provedor.class)
    @JoinColumn(name = "prov_lib", updatable=false, insertable=false)
	private Provedor provedor;
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Provedor getProvedor() {
		return provedor;
	}

	public void setCategoria(Provedor provedor) {
		this.provedor = provedor;
	}

	public Libro(String ISBN, String titulo, int categoria, float precio, int provedor) {
		isbn_lib = ISBN;
		tit_lib = titulo;
		cat_lib = categoria;
		pre_lib = precio;
		prov_lib = provedor;
	}
	
	public Libro() {	
	}
	
	public int getnum_lib() {
		return num_lib;
	}
	
	protected void setnum_lib(int Numero) {
		this.num_lib = Numero;
	}

	public String getisbn_lib() {
		return isbn_lib;
	}

	public void setisbn_lib(String ISBN) {
		this.isbn_lib = ISBN;
	}

	public String gettit_lib() {
		return tit_lib;
	}

	public void settit_lib(String Titulo) {
		this.tit_lib = Titulo;
	}

	public int getcat_lib() {
		return cat_lib;
	}

	public void setcat_lib(int Categoria) {
		this.cat_lib = Categoria;
	}

	public float getpre_lib() {
		return pre_lib;
	}

	public void setpre_lib(float Precio) {
		this.pre_lib = Precio;
	}
	

	public int getprov_lib() {
		return prov_lib;
	}

	public void setprov_lib(int prov_lib) {
		this.prov_lib = prov_lib;
	}


	public String toString() {
		return this.num_lib+"\t\t"+this.isbn_lib+"\t\t"+this.tit_lib+"\t\t"+this.pre_lib+"\t\t"+this.cat_lib;
	}
	

	
}
