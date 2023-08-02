package com.nick.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author Nick
 * @Classname HelloAspect
 * @Date 2023/08/01 14:22
 * @Description TODO
 */
@Component
@Aspect
public class ByeAspect implements Ordered {
	@Pointcut("execution(* com.nick.biz.*.findPid(..))")
	private void a() {

	}

	@Around("a()")
	public Object show(ProceedingJoinPoint joinPoint) {
		System.out.println("ByeAspect的show前面...");
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		System.out.println("ByeAspect的show后面===");
		return obj;
	}

	@Override
	public int getOrder() {
		return 10;
	}
}
