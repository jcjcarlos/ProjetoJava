import java.sql.*;
import java.util.List;

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
		List<ContatosModel> contatos = contatoDAO.getContatos();
		contatoView.showContatos(contatos);
		
		ContatosModel contatoForUpdate = contatos.get(0);
		contatoForUpdate.setNome("New Name!");
		contatoDAO.update(contatoForUpdate);
		
		
	}

}
