package com.nick;

import com.nick.biz.OrderBiz;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Nick
 * @Classname App
 * @Date 2023/08/01 8:56
 * @Description TODO
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		OrderBiz orderBiz = context.getBean(OrderBiz.class);
		// orderBiz.makeOrder(1, 99);
		// orderBiz.findOrderId("apple");
		// orderBiz.findOrderId("apple");
		// orderBiz.findOrderId("pear");
		// orderBiz.findPid("apple");
		orderBiz.findPid("apple");
	}
}
