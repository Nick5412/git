package com.nick.staticproxy;

/**
 * @author Nick
 * @Classname StaticProxy
 * @Date 2023/08/01 18:44
 * @Description TODO
 */
public class StaticProxy implements OrderBiz {
	//目标类的引用 setXxx或构造方法注入
	private OrderBiz orderBiz;

	public StaticProxy(OrderBiz orderBiz) {
		this.orderBiz = orderBiz;
	}

	@Override
	public void addOrder(int pid, int num) {
		//前置增强
		showHello();
		orderBiz.addOrder(pid, num);
		//	后置增强
		showBye();
	}

	@Override
	public void findOrder() {

	}

	public void showHello() {
		System.out.println("hello");
	}

	public void showBye() {
		System.out.println("bye");
	}
}
