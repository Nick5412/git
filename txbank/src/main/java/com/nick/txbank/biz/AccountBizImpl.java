package com.nick.txbank.biz;

import org.springframework.stereotype.Service;

/**
 * @author Nick
 * @Classname AccountBizImpl
 * @Date 2023/08/02 14:15
 * @Description TODO
 */
@Service
public class AccountBizImpl implements AccountBiz {

	@Override
	public void addAccount(int accountId, double money) {
		System.out.println("添加账户: " + accountId + " 金额: " + money);
	}
}
