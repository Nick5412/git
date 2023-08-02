package com.nick.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Nick
 * @Classname CglibProxyTool
 * @Date 2023/08/01 21:17
 * @Description TODO
 */
public class CglibProxyTool implements MethodInterceptor {
	//目标类的引用
	private Object target;

	public CglibProxyTool(Object target) {
		this.target = target;
	}

	//生成代理对象
	public Object createProxy() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		Object proxy = enhancer.create();
		return proxy;
	}

	@Override
	public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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
}
