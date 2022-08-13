package dao;

import dao.HIBERNATE.DAOHIBFactory;
import dao.JDBC.DAOJDBCFactory;
import dao.JPA.DAOJPAFactory;

public class DAOAbstractFactory{
	public static DAOFactory getInstance() {
		String tipo = "JPA";
		if(tipo.equals("Hibernate")) {
			return new DAOHIBFactory();
			
		} else if(tipo.equals("JDBC")){
			return new DAOJDBCFactory();
			
		} else{
			return new DAOJPAFactory();
		}
	}
}
