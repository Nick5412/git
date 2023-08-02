package com.nick.jdkproxy;

import com.nick.staticproxy.OrderBiz;
import com.nick.staticproxy.OrderBizImpl;

/**
 * @author Nick
 * @Classname Test2
 * @Date 2023/08/01 19:24
 * @Description TODO
 */
public class Test2 {
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		JdkProxyTool jpt = new JdkProxyTool(new OrderBizImpl());
		OrderBiz ob = (OrderBiz) jpt.createProxy();
		// System.out.println("生成代理类对象: "+ob);

		ob.findOrder();
		// ob.addOrder(1,99);
	}
}
