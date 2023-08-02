package maven.dbhelper;

import maven.dbhelper.user.BankAccount;
import maven.dbhelper.user.BankAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Nick
 * @Classname App
 * @Date 2023/07/26 15:48
 * @Description TODO
 */
public class App {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		// DataSource dataSource = (DataSource) context.getBean("myDataSource");
		// Connection connection = dataSource.getConnection();
		// System.out.println(connection);

		BankAccountDao bad = (BankAccountDao) context.getBean("bankAccountDao");
		List<BankAccount> list = bad.findAll();
		for (BankAccount bankAccount : list) {
			System.out.println(bankAccount);
		}
	}
}
