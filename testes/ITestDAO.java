package testes;

import java.sql.SQLException;

import dao.ContatosDAO;

public abstract class ITestDAO {
	protected static ContatosDAO contatosDAO;
	
	public ITestDAO() throws SQLException {
		contatosDAO = new ContatosDAO();
	}
}
