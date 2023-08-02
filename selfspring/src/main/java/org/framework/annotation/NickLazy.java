package org.framework.annotation;

/**
 * @author Nick
 * @Classname NickLazy
 * @Date 2023/07/27 15:52
 * @Description TODO
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NickLazy {
	boolean value() default true;
}
