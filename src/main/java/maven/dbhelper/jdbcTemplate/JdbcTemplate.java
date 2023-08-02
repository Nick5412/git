package maven.dbhelper.jdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nick
 * @Classname JdbcTemplate
 * @Date 2023/07/26 20:18
 * @Description TODO
 */
public abstract class JdbcTemplate<T> {
	private DataSource dataSource;

	public JdbcTemplate(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<T> executeQuery(String sql, RowMapper<T> rowMapper, Object... params) {
		List<T> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//1.联接池中获取联接
			con = dataSource.getConnection();
			//2. 创建语句对象 PreparedStatement
			pstmt = con.prepareStatement(sql);
			//3. 设置参数
			setParams(pstmt, params);
			//4. 查询
			rs = pstmt.executeQuery();
			//5. 循环resultSet
			int i = 0;
			while (rs.next()) {
				T t = rowMapper.mapper(rs, i);
				i++;
				list.add(t);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		}
		return list;
	}

	private void setParams(PreparedStatement pstmt, Object... params) throws SQLException {
		if (pstmt == null || params.length < 0) {
			return;
		}
		for (int i = 0; i < params.length; i++) {
			pstmt.setObject(i + 1, params[i]);
		}
	}
}
