package org.framework.context;

/**
 * @author Nick
 * @Classname NickBeanDefinition
 * @Date 2023/07/27 17:08
 * @Description TODO
 */

import lombok.Data;

/**
 * 对一个Bean的特征的包装的类
 * 特征: scope
 * lazy
 * primary: 主实例|优先实例 加在接口实现类上
 */
@Data
public class NickBeanDefinition {
	private String scope = "singleton";
	private boolean isLazy;
	private boolean isPrimary;
	private String classInfo;
}
