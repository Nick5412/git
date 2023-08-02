package maven.tool.user;

import maven.tool.system.ContainerFilter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Nick
 * @Classname StudentBmiFilter
 * @Date 2023/07/26 9:39
 * @Description TODO
 */
@Component(value = "bmiFilter")
public class StudentBmiFilter implements ContainerFilter {
	private Logger logger = Logger.getLogger(StudentBmiFilter.class);

	@Override
	public boolean doFilter(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student stu = (Student) obj;
		if (stu.getName() == null || "".equalsIgnoreCase(stu.getName())) {
			logger.error("姓名不能为空: " + stu);
			return false;
		}
		if (stu.getHeight() < 1 || stu.getHeight() > 2.5) {
			logger.error("身高异常: " + stu);
			return false;
		}
		if (stu.getWeight() < 30 || stu.getWeight() > 200) {
			logger.error("体重异常: " + stu);
			return false;
		}
		return true;
	}
}
