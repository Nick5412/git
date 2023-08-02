package org.framework.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Nick
 * @Classname NickResource
 * @Date 2023/07/27 15:46
 * @Description TODO
 */
@Target({TYPE, FIELD, METHOD, CONSTRUCTOR})
@Retention(RUNTIME)
public @interface NickResource {
	//指定要装配的id
	String name() default "";
}
