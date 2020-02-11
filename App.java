import java.sql.*;

public class App {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ListaModel listaModel = new ListaModel();
		
		listaModel.nome = "Name";
		listaModel.endereco = "Address";
		listaModel.telefone = "phoneNumber";
		
		ListaDAO listaDAO = new ListaDAO();
		listaDAO.save(listaModel);
	}

}
