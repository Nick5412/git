package org.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Nick
 * @Classname NickController
 * @Date 2023/07/27 15:13
 * @Description TODO
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@NickComponent
public @interface NickController {
	String value() default "";
}
