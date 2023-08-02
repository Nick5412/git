package maven.tool;

import maven.tool.system.ToolBox;
import maven.tool.user.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Nick
 * @Classname App
 * @Date 2023/07/26 10:11
 * @Description TODO
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		ToolBox toolBox = (ToolBox) context.getBean("toolBox");
		toolBox.add(new Student("张三", 1.7, 90));
		toolBox.add(new Student("李四", 1.8, 80));
		toolBox.add(new Student("王五", 1.6, 100));
		toolBox.add(new Student("异常", 0.3, 1));
		System.out.println(toolBox.getMax());
		System.out.println(toolBox.getMin());
		System.out.println(toolBox.getAvg());
		System.out.println(toolBox.size());
	}
}
