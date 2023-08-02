package com.nick.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Nick
 * @Classname JdkProxyTool
 * @Date 2023/08/01 19:18
 * @Description TODO
 */
public class JdkProxyTool implements InvocationHandler {
	//目标类的引用
	private Object target;

	public JdkProxyTool(Object target) {
		this.target = target;
	}

	//生成代理对象
	public Object createProxy() {
		ClassLoader loader = JdkProxyTool.class.getClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		Object proxy = Proxy.newProxyInstance(loader, interfaces, this);
		return proxy;
	}

	//当在主程序中调用生成的Proxy的中的方法,会自动回调这个invoke(),在invoke()加入增强,切面这些功能
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().startsWith("find")) {
			showHello();
		}
		//调用目标类的方法
		Object returnValue = method.invoke(target, args);

		return returnValue;
	}

	public void showHello() {
		System.out.println("hello");
	}

	public void showBye() {
		System.out.println("bye");
	}
}
