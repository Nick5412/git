package com.nick.staticproxy;

/**
 * @author Nick
 * @Classname Test
 * @Date 2023/08/01 18:48
 * @Description TODO
 */
public class Test {
	public static void main(String[] args) {
		OrderBiz ob = new StaticProxy(new OrderBizImpl());
		ob.addOrder(1, 10);
	}
}
