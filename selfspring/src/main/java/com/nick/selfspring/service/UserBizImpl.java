package com.nick.selfspring.service;

import com.nick.selfspring.dao.UserDao;
import org.framework.annotation.NickResource;
import org.framework.annotation.NickService;

/**
 * @author Nick
 * @Classname UserBizImpl
 * @Date 2023/07/27 15:56
 * @Description TODO
 */
@NickService
public class UserBizImpl implements UserBiz {
	@NickResource(name = "userDaoImpl")
	private UserDao userDao;

	@Override
	public void add(String uname) {
		userDao.add(uname);
	}
}
