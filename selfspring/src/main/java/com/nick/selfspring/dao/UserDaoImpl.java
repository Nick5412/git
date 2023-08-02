package com.nick.selfspring.dao;

import org.framework.annotation.NickRepository;

/**
 * @author Nick
 * @Classname UserDao
 * @Date 2023/07/27 15:54
 * @Description TODO
 */
@NickRepository
public class UserDaoImpl implements UserDao {
	@Override
	public void add(String uname) {
		System.out.println("添加了 " + uname);
	}
}
