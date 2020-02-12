import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ContatosDAO {
	
	private Connection conn;
	
	public ContatosDAO() throws SQLException {
	}
	
	public void save(ContatosModel contato) {
		
		try (Connection conn = ConnectionFactory.getConnection()) {
			String query = "INSERT INTO contatos (nome,email,endereco,dataNascimento) VALUES (?,?,?,?)";
			//Try-with-resources Executa o AutoCloseable
			try (PreparedStatement pstmt = conn.prepareStatement(query)) {
				pstmt.setString(1, contato.getNome());
				pstmt.setString(2,contato.getEmail());
				pstmt.setString(3, contato.getEndereco());
				pstmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
				pstmt.execute();
				pstmt.close();
				System.out.println("Dados Salvos com sucesso");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Não foi possível executar a query");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}catch(SQLException e) {
			System.out.println("Não foi possível realizar conexão com o banco de dados");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<ContatosModel> getContatos(){
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "SELECT * FROM contatos";
			List contatos = new ArrayList<ContatosModel>();
			try(PreparedStatement pstmt = conn.prepareStatement(query)){
				ResultSet result = pstmt.executeQuery();
				while(result.next()) {
					ContatosModel contato = new ContatosModel();
					contato.setNome(result.getString("nome"));
					contato.setEmail(result.getString("email"));
					contato.setEndereco(result.getString("endereco"));
					
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(result.getDate("dataNascimento"));
					contato.setDataNascimento(calendar);
					
					contatos.add(contato);
				}
				result.close();
				return contatos;
			}catch(SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new RuntimeException(e1);

		}
	}
}
