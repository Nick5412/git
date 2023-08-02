package com.nick.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Nick
 * @Classname MyAspect
 * @Date 2023/08/01 9:08
 * @Description TODO
 */
@Component
@Aspect
public class MyAspect {
	private Map<String, Long> map = new ConcurrentHashMap<>();
	private Map<String, Long> map2 = new ConcurrentHashMap<>();

	@Pointcut("execution(* com.nick..biz.*.makeOrder(..))")
	private void anyOldTransfer() {
	}

	@Around(value = "anyOldTransfer()")
	public Object getAround(ProceedingJoinPoint joinPoint) {
		Object o = null;
		System.out.println("前置增强");
		long start = System.currentTimeMillis();
		try {
			o = joinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("用时: " + (end - start) + "毫秒");
		System.out.println("后置增强");
		return o;
	}

	// @Before(value = "anyOldTransfer()")
	public void recordTime() {
		Date date = new Date();
		System.out.println("下订单的时间: " + date);
	}

	// @AfterThrowing(value = "anyOldTransfer()",throwing = "ex")
	public void throwing(ArithmeticException ex) {
		System.out.println(ex);
	}

	// @AfterReturning(value = "anyOldTransfer()", returning = "obj")
	public void sendEmail(JoinPoint joinPoint, Object obj) {
		System.out.println("增强的方法为: " + joinPoint.getTarget());
		Object[] args = joinPoint.getArgs();
		System.out.println("方法参数有: ");
		for (Object arg : args) {
			System.out.println("arg = " + arg);
		}
		System.out.println("返回值: " + obj);
	}

	@Pointcut("execution(* com.nick..find*(String))")
	private void gets() {

	}

	@AfterReturning(value = "gets()")
	public void getNum(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		String arg = (String) args[0];
		Long num = 1l;
		if (map.containsKey(arg)) {
			num = map.get(arg);
			num++;
		}
		map.put(arg, num);
		System.out.println("统计结果: " + map);
	}

	@AfterReturning(value = "gets()", returning = "ret")
	public void recordPnameCount(JoinPoint joinPoint, int ret) {
		Object[] args = joinPoint.getArgs();
		String arg = (String) args[0];
		Long num = 1l;
		if (map2.containsKey(arg)) {
			num = map2.get(arg);
			num++;
		}
		map2.put(arg + ":" + ret, num);
		System.out.println("统计结果: " + map2);
	}

}
