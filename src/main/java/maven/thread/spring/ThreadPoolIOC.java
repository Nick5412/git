package maven.thread.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

/**
 * @author Nick
 * @Classname ThreadPoolIOC
 * @Date 2023/07/25 19:08
 * @Description TODO
 */
public class ThreadPoolIOC {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		ExecutorService executor = (ExecutorService) context.getBean("threadPoolExecutor");
		for (int i = 0; i < 5; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					while (true) {
						Date date = new Date();
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String s = format.format(date);
						System.out.println(Thread.currentThread().getName() + " 的时间为 " + s);
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
		}
	}
}
