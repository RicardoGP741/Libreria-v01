package beans;

import java.util.List;

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
	private String nom_prov;
	@OneToMany 
	@JoinColumn(name = "id_prov")
	private List<Provedor> ListaDeProvedores;
	
	public Provedor() {
	}

	public int getid_cat() {
		return id_prov;
	}

	public void setid_cat(int id_prov) {
		this.id_prov = id_prov;
	}

	public String getnom_cat() {
		return nom_prov;
	}

	public void setnom_cat(String nom_prov) {
		this.nom_prov = nom_prov;
	}



	//CAMBIAR LOS ARRAYLIST POR LIST (SOLO LO PRIMERO Y EL RETORNO)
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public static List<Provedor> buscarProvedores() throws DataBaseException {
	
		String consultaSQL ="SELECT * FROM provedores";
		DataBaseHelper dbh = new DataBaseHelper();
		List <Provedor>ListaDeProvedores=dbh.seleccionarRegistros(consultaSQL, Provedor.class);

		dbh.cerrarObjetos();
		System.out.println("============= ListaDeProvedores =============== \n"+ ListaDeProvedores);
		return ListaDeProvedores;
		
	}
}
