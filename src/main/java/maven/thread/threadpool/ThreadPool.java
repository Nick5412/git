package maven.thread.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Nick
 * @Classname ThreadPool
 * @Date 2023/07/25 18:58
 * @Description TODO
 */
public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService executor = new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS
				, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.DiscardPolicy() {
		});

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
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
		}
	}
}
