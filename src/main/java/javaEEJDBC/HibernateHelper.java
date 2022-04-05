package javaEEJDBC;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
		private static SessionFactory buildSessionFactory() {
			try {
				return new Configuration().configure().buildSessionFactory();
			}
			catch(Throwable ex) {
				System.err.println("Error al crear la session en factory"+ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}
	}

