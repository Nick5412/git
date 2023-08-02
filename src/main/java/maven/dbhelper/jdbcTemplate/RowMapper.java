package maven.dbhelper.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Nick
 * @Classname RowMapper
 * @Date 2023/07/26 11:35
 * @Description TODO
 */
public interface RowMapper<T> {
	//结果集第i行数据
	T mapper(ResultSet rs, int i) throws SQLException;
}
