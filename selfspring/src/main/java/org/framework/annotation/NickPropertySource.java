package org.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Nick
 * @Classname NickPropertySource
 * @Date 2023/07/27 15:50
 * @Description TODO
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NickPropertySource {
	String name() default "";

	String[] value();
}
