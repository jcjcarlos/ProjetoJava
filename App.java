import java.sql.*;

public class App {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		Connection conn = Database.getConnection();
		conn.prepareStatement("INSERT INTO lista (nome,telefone,endereco) VALUES (?,?,?)");
	}

}
