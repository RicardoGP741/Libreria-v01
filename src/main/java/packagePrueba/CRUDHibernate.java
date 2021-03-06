package packagePrueba;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import beans.Libro;
import dbHelpers.DataHibernate;

public class CRUDHibernate {

		public static void main(String [] args) {
			
			CRUDHibernate hib = new CRUDHibernate();
			hib.leerLibros();
			
		}
		public void leerLibros() {
			Session session = null;
			
			try {
				SessionFactory factoria = new Configuration().configure().buildSessionFactory();
				session = factoria.openSession();
				Query consulta = session.createQuery("from Libro libro");
				List<Libro> listaLibros = consulta.list();
				for(Libro L:listaLibros) {
					System.out.println(L.getnum_lib()+ "\t\t"+L.getisbn_lib()+"\t\t"+L.gettit_lib()+"\t\t"+L.getcat_lib()+"\t\t"+L.getCategoria().getnom_cat());
				}
			} catch(HibernateException e) {
				System.out.println(e.getMessage());
			} finally {
				if(session!=null) session.close();
			}
		}
		
//		public void altaLibro(String isbn_lib, String tit_lib, int cat_lib, float pre_lib) {
//			Session session = null;
//			Transaction transaccion = null;
//			try {
//				SessionFactory factoria = new Configuration().configure().buildSessionFactory();
//				session = factoria.openSession();
//				transaccion = session.beginTransaction();
//				Libro lib = new Libro(isbn_lib, tit_lib,cat_lib,pre_lib);
//				session.save(lib);
//				transaccion.commit();
//				
//			} catch(HibernateException e) {
//				System.out.println(e.getMessage());			
//				try {
//					transaccion.rollback();
//				} catch(IllegalStateException e1){
//					System.out.println("no se hizo el rollback");
//					e1.printStackTrace();
//				}
//			} catch(SecurityException e1) {
//				e1.printStackTrace();
//			} 
//			finally {
//				if(session!=null) session.close();
//			}
//			
//		}
//		
//		public void updateLibro(int id, String isbn_lib, String tit_lib, int cat_lib, float pre_lib) {
//			Session session = null;
//			Transaction transaccion = null;
//			try {
//				SessionFactory factoria = new Configuration().configure().buildSessionFactory();
//				session = factoria.openSession();
//				transaccion = session.beginTransaction();
//				Libro lib = session.get(Libro.class, id);
//				if(lib != null) {
//					lib.setisbn_lib(isbn_lib);
//					lib.settit_lib(tit_lib);
//					lib.setcat_lib(cat_lib);
//					lib.setpre_lib(pre_lib);
//					session.saveOrUpdate(lib);
//				}
//				transaccion.commit();
//			} catch(HibernateException e) {
//				System.out.println(e.getMessage());			
//				try {
//					transaccion.rollback();
//				} catch(IllegalStateException e1){
//					System.out.println("no se hizo el rollback");
//					e1.printStackTrace();
//				}
//			} catch(SecurityException e1) {
//				e1.printStackTrace();
//			} 
//			finally {
//				if(session!=null) session.close();
//			}
//		}
//		
//		
//		public void borrarLibro(int id) {
//			Session session = null;
//			Transaction transaccion = null;
//			try {
//				SessionFactory factoria = new Configuration().configure().buildSessionFactory();
//				session = factoria.openSession();
//				transaccion = session.beginTransaction();
//				Libro lib = session.get(Libro.class, id);
//				if(lib != null) {
//					session.delete(lib);
//					System.out.println("Se borro el libro:" + lib.gettit_lib());
//				}
//				transaccion.commit();
//			} catch(HibernateException e) {
//				System.out.println(e.getMessage());			
//				try {
//					transaccion.rollback();
//				} catch(IllegalStateException e1){
//					System.out.println("no se hizo el rollback");
//					e1.printStackTrace();
//				}
//			} catch(SecurityException e1) {
//				e1.printStackTrace();
//			} 
//			finally {
//				if(session!=null) session.close();
//			}
//		}
}
