package org.framework.annotation;

import java.lang.annotation.*;

/**
 * @author Nick
 * @Classname NickQualifier
 * @Date 2023/07/27 15:44
 * @Description TODO
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface NickQualifier {
	String value() default "";
}
