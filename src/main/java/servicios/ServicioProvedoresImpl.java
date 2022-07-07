package servicios;

import java.util.List;

import beans.Provedor;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.ProvedoresDAO;
import dbHelpers.DataBaseException;

public class ServicioProvedoresImpl implements ServicioProvedores {

	private ProvedoresDAO provedoresDAO=null;
	
	public ServicioProvedoresImpl() {
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		provedoresDAO = factoria.getProvedorDAO();
	}

	@Override
	public void insertar(Provedor prov) {
		// TODO Auto-generated method stub
		provedoresDAO.insertar(prov);
	}

	@Override
	public List<Provedor> buscarTodos() {
		return provedoresDAO.buscarTodos();
	}

	@Override
	public void borrar(Provedor prov) {
		// TODO Auto-generated method stub
		provedoresDAO.insertar(prov);
	}

	@Override
	public void guardarCambios(Provedor prov) {
		// TODO Auto-generated method stub
		provedoresDAO.guardarCambios(prov);
	}

	@Override
	public List<Provedor> buscarProvedores() throws DataBaseException {
		// TODO Auto-generated method stub
		return provedoresDAO.buscarProvedores();
	}
	
	
}
