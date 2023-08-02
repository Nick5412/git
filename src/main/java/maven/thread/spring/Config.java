package maven.thread.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Nick
 * @Classname Config
 * @Date 2023/07/25 21:32
 * @Description TODO
 */
@Configuration
@ComponentScan(basePackages = {"maven.thread.spring"})
public class Config {
	@Bean
	public ExecutorService threadPoolExecutor() {
		return new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS
				, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.DiscardPolicy() {
		});
	}
}
