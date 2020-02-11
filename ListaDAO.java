import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class ListaDAO {
	
	private Connection conn;
	
	public ListaDAO() {
		this.conn = ConnectionFactory.getConnection();
	}
	
	public void save(ListaModel lista) {
		try {
			PreparedStatement pstmt = this.conn.prepareStatement("INSERT INTO lista (nome,telefone,endereco,data) VALUES (?,?,?,?)");
			pstmt.setString(1, lista.nome);
			pstmt.setString(2,lista.telefone);
			pstmt.setString(3, lista.endereco);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
