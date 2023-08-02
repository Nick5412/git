package com.nick.staticproxy;

/**
 * @author Nick
 * @Classname OrderBiz
 * @Date 2023/08/01 18:42
 * @Description 抽象主题
 */
public interface OrderBiz {
	void addOrder(int pid, int num);

	void findOrder();
}
