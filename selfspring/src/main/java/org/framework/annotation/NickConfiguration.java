package org.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Nick
 * @Classname NickConfiguration
 * @Date 2023/07/27 15:02
 * @Description TODO
 */
//类或接口
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@NickComponent
public @interface NickConfiguration {
	String value() default "";
}
