package javaEEJDBC;

import java.io.File;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import packagePrueba.CRUDHibernate;



@Entity
@Table(name = "libros")
public class Libro {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_lib;
	private String isbn_lib;
	private String tit_lib;
	private int cat_lib;
	private float pre_lib;
	

	public Libro(String ISBN, String titulo, int categoria, float precio) {
		isbn_lib = ISBN;
		tit_lib = titulo;
		cat_lib = categoria;
		pre_lib = precio;
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
	

	public static void main(String [] args) {
		
		Libro lib = new Libro();
		
		System.out.println(lib.buscarTodos());
		
	}
	
	public static List<Integer> buscarLasCategorias() throws DataBaseException{
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		String consulta = "SELECT DISTINCT libro.cat_lib from Libro libro";
		List<Integer> ListaDecat_libs = session.createQuery(consulta).list();
		session.close();
		return ListaDecat_libs;
	}
	
	public void insertar (){
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
	}
	
	
//	public static List<Libro> buscarTodos()throws DataBaseException {
//		String SQL ="SELECT * FROM libros";
//		DataBaseHelper  dbh = new DataBaseHelper();
//		List<Libro>ListaDeLibros = dbh.seleccionarRegistros(SQL, Libro.class);
//		dbh.cerrarObjetos();
//		return ListaDeLibros;
//	}
	
	public List<Libro> buscarTodos(){
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		List<Libro>ListaDeLibros = session.createQuery("from Libro libro").list();
		session.close();
		return ListaDeLibros;
	}
	
	
	public Libro buscarLibro(int id) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Libro libro = (Libro)session.get(Libro.class, id);
		session.close();
		return libro;
	}
			
	
	public void BorrarLibro(){
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.delete(this);
		session.getTransaction().commit();
	}
	
	public static List<Libro> buscarPorCategoria(int cat){
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Query consulta = session.createQuery("FROM Libro libro WHERE libro.cat_lib ="+cat);
		List<Libro> ListaDeLibros = consulta.list();
		session.close();
		return ListaDeLibros;
		
	}
	
	
	
	
}
