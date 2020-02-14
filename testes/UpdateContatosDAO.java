package testes;

import java.sql.SQLException;
import java.util.List;

import model.ContatosModel;

public class UpdateContatosDAO extends ITestDAO {

	public UpdateContatosDAO() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private void updateDAOById() {
		ContatosModel contatoForUpdate = ITestDAO.contatosDAO.getContatoByID(1);
		contatoForUpdate.setNome("New Name!");
		ITestDAO.contatosDAO.update(contatoForUpdate);
	}

}
