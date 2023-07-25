import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Nick
 * @Classname Connection
 * @Date 2023/07/21 20:58
 * @Description TODO
 */
public class Connection {
	public String getConnection() {
		String url = "jdbc:mysql//localhost:3308";
		String username = "root";
		String password = "1234";
		java.sql.Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return connection.toString();
	}
}
