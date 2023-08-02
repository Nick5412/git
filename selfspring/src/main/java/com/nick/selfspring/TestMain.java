package com.nick.selfspring;


import com.nick.selfspring.service.UserBiz;
import org.framework.context.NickAnnotationConfigApplicationContext;
import org.framework.context.NickApplicationContext;

/**
 * @author Nick
 * @Classname TestMain
 * @Date 2023/07/27 14:36
 * @Description TODO
 */
public class TestMain {
	public static void main(String[] args) {
		// Logger logger = LoggerFactory.getLogger(TestMain.class);
		NickApplicationContext context = new NickAnnotationConfigApplicationContext(MyConfig.class);
		UserBiz userBiz = (UserBiz) context.getBean("userBizImpl");
		userBiz.add("张三");
	}
}
