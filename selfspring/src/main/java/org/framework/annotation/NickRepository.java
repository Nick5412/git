package org.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Nick
 * @Classname NickRepository
 * @Date 2023/07/27 15:10
 * @Description TODO
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@NickComponent
public @interface NickRepository {
	String value() default "";
}
