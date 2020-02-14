package dao;
import model.ContatosModel;
import database.ConnectionFactory;
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
	
	public void update(ContatosModel contato) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "UPDATE contatos SET nome = ?, email = ?, endereco = ?, dataNascimento = ? WHERE id = ?";
			try(PreparedStatement pstmt = conn.prepareStatement(query)){
				pstmt.setString(1, contato.getNome());
				pstmt.setString(2, contato.getEmail());
				pstmt.setString(3, contato.getEndereco());
				pstmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
				pstmt.setLong(5, contato.getId());
				pstmt.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
					contato.setId(result.getLong("id"));
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
	
	public ContatosModel getContatoByID(int id) {
		ContatosModel contato = null;
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "SELECT * FROM Contatos WHERE id = ?";
			try(PreparedStatement pstmt = conn.prepareStatement(query)){
				pstmt.setInt(1, id);
				ResultSet result = pstmt.executeQuery();
				if(result.next()) {//Há somente um registro
					contato.setNome(result.getString("nome"));
					contato.setId(result.getLong("id"));
					contato.setEmail(result.getString("email"));
					contato.setEndereco(result.getString("endereco"));
					Calendar data = Calendar.getInstance();
					data.setTime(result.getDate("dataNascimento"));
					contato.setDataNascimento(data);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			//Evita rescrever o return para o try e outro para o catch
			//Independente do caso, irá retornar o contato, seja com valor nulo ou o objeto ContatosModel
			return contato;
		}
	}
	
	public boolean remove(long id) {
		boolean isRemove = false;
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "DELETE FROM Contatos WHERE id = ?";
			try(PreparedStatement pstmt = conn.prepareStatement(query)){
				pstmt.setLong(1, id);
				isRemove = pstmt.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			return isRemove;
		}
	}
}
