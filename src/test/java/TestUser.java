import maven.Config;
import maven.biz.UserBiz;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Nick
 * @Classname TestUser
 * @Date 2023/07/25 16:17
 * @Description TODO
 */
public class TestUser {
	public static void main(String[] args) {
		//IOC
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		//	DI
		// UserDao userDaoImpl = (UserDao) context.getBean("userDaoImpl");
		// userDaoImpl.add("张三");

		UserBiz userBizImpl = (UserBiz) context.getBean("userBizImpl");
		userBizImpl.add("李四");
	}

}
