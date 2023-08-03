package com.nick.txbank.dao;

import com.nick.txbank.bean.Account;

import java.util.List;

/**
 * @author Nick
 * @Classname AccountDao
 * @Date 2023/08/03 9:31
 * @Description
 */
public interface AccountDao {
	/**
	 * 添加Account账号
	 *
	 * @param money
	 * @return
	 */
	int insert(double money);

	/**
	 * 根据accountid更新money
	 *
	 * @param accountid
	 * @param money     正存负取
	 */
	void update(int accountid, double money);

	/**
	 * 删除账号
	 *
	 * @param accountid
	 */
	void delete(int accountid);

	/**
	 * 查询账户总数
	 *
	 * @return
	 */
	int findCount();

	/**
	 * 查询所有账户
	 *
	 * @return
	 */
	List<Account> findAll();

	/**
	 * 根据id查询账户
	 *
	 * @param accountid
	 * @return
	 */
	Account findById(int accountid);
}
