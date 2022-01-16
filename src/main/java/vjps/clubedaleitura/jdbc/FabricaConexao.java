package vjps.clubedaleitura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por realizar uma conexão com o banco de dados "clubedaleitura"
 * e disponibilizar um objeto Connection que possa ser usado em toda a aplicação.
 * @author Vinícius José Pires Silva
 */
public class FabricaConexao {

	private static final String BD_URL = "jdbc:postgresql://localhost/clubedaleitura",
			USER = "postgres", PASSWD = "123456";
	
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(BD_URL, USER, PASSWD);
		} catch (SQLException | ClassNotFoundException exception) {
			exception.printStackTrace();
		}
		
		return null;
	}
	
}// class FabricaConexao
