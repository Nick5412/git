package com.nick.biz;

/**
 * @author Nick
 * @Classname OrderBiz
 * @Date 2023/08/01 8:53
 * @Description TODO
 */
public interface OrderBiz {
	int makeOrder(int pid, int num);

	int findOrderId(String pname);

	int findPid(String pname);
}
