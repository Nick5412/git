package maven.dbhelper.user;

import maven.dbhelper.jdbcTemplate.JdbcTemplate;
import maven.dbhelper.jdbcTemplate.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Nick
 * @Classname BankAccountDao
 * @Date 2023/07/26 21:08
 * @Description TODO
 */
@Repository
public class BankAccountDao extends JdbcTemplate {

	@Autowired
	public BankAccountDao(DataSource dataSource) {
		super(dataSource);
	}

	public List<BankAccount> findAll() {
		String sql = "select * from bank";
		return super.executeQuery(sql, new RowMapper() {
			@Override
			public BankAccount mapper(ResultSet rs, int i) throws SQLException {
				BankAccount account = new BankAccount();
				account.setId(rs.getInt(1));
				account.setBalance(rs.getDouble(2));
				return account;
			}
		});
	}
}
