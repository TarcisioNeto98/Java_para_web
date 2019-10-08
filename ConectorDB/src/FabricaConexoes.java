import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {
	
	public static Connection getConection() throws SQLException{
		
		return DriverManager.getConnection("jdbc:postgresql://localhost/Teste", "postgres", "residentevil1998");
		
	}

}
