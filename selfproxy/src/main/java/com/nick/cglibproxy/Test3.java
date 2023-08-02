package com.nick.cglibproxy;

/**
 * @author Nick
 * @Classname Test3
 * @Date 2023/08/01 21:17
 * @Description TODO
 */
public class Test3 {
	public static void main(String[] args) {
		CglibProxyTool cpt = new CglibProxyTool(new OrderBizImpl());
		OrderBizImpl ob = (OrderBizImpl) cpt.createProxy();
		// System.out.println("生成代理类对象: "+ob);

		ob.findOrder();
	}
}
