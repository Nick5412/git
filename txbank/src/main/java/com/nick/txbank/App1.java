package com.nick.txbank;

import com.nick.txbank.biz.AccountBiz;
import com.nick.txbank.biz.AccountBizImpl;
import com.nick.txbank.configs.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Nick
 * @Classname App1
 * @Date 2023/08/02 14:18
 * @Description TODO
 */
public class App1 {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		AccountBiz ab = context.getBean(AccountBizImpl.class);
		//功能 => 用例
		ab.addAccount(1, 99);
	}
}
