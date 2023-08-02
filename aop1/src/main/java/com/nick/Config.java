package com.nick;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Nick
 * @Classname Config
 * @Date 2023/08/01 8:55
 * @Description TODO
 */
@Configuration
@ComponentScan(basePackages = "com.nick")
@EnableAspectJAutoProxy
public class Config {
}
