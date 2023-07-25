package maven.biz.impl;

import maven.biz.UserBiz;
import maven.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Nick
 * @Classname UserBizImpl
 * @Date 2023/07/25 16:15
 * @Description TODO
 */
@Service
public class UserBizImpl implements UserBiz {
	//Resource根据名字注入
	// @Resource(name = "userDaoImpl")

	//Autowired根据类型注入
	@Autowired
	//限定使用哪一个Bean,不能使用userDao
	@Qualifier("userDaoImpl")
	private UserDao userDao;

	@Override
	public void add(String name) {
		userDao.add(name);
	}
}
