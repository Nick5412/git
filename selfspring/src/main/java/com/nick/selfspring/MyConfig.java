package com.nick.selfspring;

import org.framework.annotation.NickComponentScan;
import org.framework.annotation.NickConfiguration;
import org.framework.annotation.NickPropertySource;

/**
 * @author Nick
 * @Classname MyConfig
 * @Date 2023/07/27 15:07
 * @Description TODO
 */
@NickComponentScan(basePackages = "com.nick.selfspring")
@NickConfiguration
@NickPropertySource(value = "classpath:db.properties")
public class MyConfig {
}
