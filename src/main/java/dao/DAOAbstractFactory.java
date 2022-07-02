package dao;

public class DAOAbstractFactory{
	public static DAOFactory getInstance() {
		String tipo = "JPA";
		if(tipo.equals("Hibernate")) {
			//new DAOHibrnateFactory();
			return null;
		} else {
			return new DAOJPAFactory();
		}
	}
}
