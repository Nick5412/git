package com.nick.cglibproxy;

/**
 * @author Nick
 * @Classname OrderBizImpl
 * @Date 2023/08/01 21:18
 * @Description TODO
 */
public class OrderBizImpl {
	public void findOrder() {
		System.out.println("查询订单...");
	}

	public void addOrder(int pid, int num) {
		System.out.println("添加订单,添加了: " + pid + "数量为: " + num);
	}

}
