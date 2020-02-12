import java.sql.*;

public class App {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ContatosModel contatoModel = new ContatosModel();
		
		contatoModel.setNome("Name");
		contatoModel.setEndereco("Address");
		contatoModel.setEmail("name@email.com");
		
		ContatosDAO contatoDAO = new ContatosDAO();
		contatoDAO.save(contatoModel);
		
		ContatosView contatoView = new ContatosView();
		contatoView.showContatos(contatoDAO.getContatos());
	}

}
