package com.nick.biz;

import org.springframework.stereotype.Service;

/**
 * @author Nick
 * @Classname OrderBizImpl
 * @Date 2023/08/01 8:54
 * @Description TODO
 */
@Service
public class OrderBizImpl implements OrderBiz {
	@Override
	public int makeOrder(int pid, int num) {
		System.out.println("makeOrder的方法调用,订单编号: " + pid + " 数量: " + num);
		// System.out.println(1/0);
		return pid;
	}

	@Override
	public int findOrderId(String pname) {
		System.out.println("findOrderId根据商品名: " + pname + " 查找商品对应的订单号");
		return 0;
	}

	@Override
	public int findPid(String pname) {
		System.out.println("findOrderId根据商品名: " + pname + " 查找商品对应的订单号");
		return (int) (Math.random() * 10);
	}
}
