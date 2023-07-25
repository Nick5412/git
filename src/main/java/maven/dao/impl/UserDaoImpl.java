package maven.dao.impl;

import maven.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author Nick
 * @Classname UserDaoImpl
 * @Date 2023/07/25 16:14
 * @Description TODO
 */
@Repository
public class UserDaoImpl implements UserDao {
	public UserDaoImpl() {
		System.out.println("UserDaoImpl无参构造");
	}

	@Override
	public void add(String uname) {
		System.out.println("添加了: " + uname);
	}
}
