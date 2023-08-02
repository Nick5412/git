package com.nick.staticproxy;

/**
 * @author Nick
 * @Classname OrderBizImpl
 * @Date 2023/08/01 18:43
 * @Description TODO
 */
public class OrderBizImpl implements OrderBiz {
	@Override
	public void findOrder() {
		System.out.println("查询订单...");
	}

	@Override
	public void addOrder(int pid, int num) {
		System.out.println("添加订单,添加了: " + pid + "数量为: " + num);
	}
}
