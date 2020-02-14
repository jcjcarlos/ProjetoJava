package testes;

import java.sql.SQLException;

import dao.ContatosDAO;
import model.ContatosModel;

public class SaveContatosDAO extends ITestDAO{

	public SaveContatosDAO() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ContatosModel contatosModel = new ContatosModel();
		contatosModel.setNome("Name");
		contatosModel.setEndereco("Address");
		contatosModel.setEmail("name@email.com");
		
		ITestDAO.contatosDAO.save(contatosModel);
	}

}
