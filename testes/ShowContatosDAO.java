package testes;

import java.util.List;

import model.ContatosModel;
import view.ContatosView;

public class ShowContatosDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ContatosView contatoView = new ContatosView();
		List<ContatosModel> contatos = ITestDAO.contatosDAO.getContatos();
		contatoView.showContatos(contatos);
		
	}
	

}
