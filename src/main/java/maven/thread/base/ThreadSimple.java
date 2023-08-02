package maven.thread.base;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Nick
 * @Classname ThreadSimple
 * @Date 2023/07/25 18:45
 * @Description TODO
 */
public class ThreadSimple {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Task task = new Task();
			new Thread(task).start();
		}
	}
}

class Task implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = format.format(date);
		System.out.println(s);
	}
}