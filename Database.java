import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject?autoReconnect=true&useSSL=false","root","root");
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
	}
}
