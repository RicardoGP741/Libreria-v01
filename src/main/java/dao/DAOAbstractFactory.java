package dao;

public class DAOAbstractFactory{
	public static DAOFactory getInstance() {
		String tipo = "JPA";
		if(tipo.equals("Hibernate")) {
			//new DAOHibrnateFactory();
			return null;
		} else if(tipo.equals("JDBC")){
			//new DAOJDBCFactory();
			return null;
		} else{
			return new DAOJPAFactory();
		}
	}
}
