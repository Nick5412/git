package maven.tool.user;

import maven.tool.system.Measure;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Nick
 * @Classname StudentBmiMeasure
 * @Date 2023/07/26 9:05
 * @Description TODO
 */
@Component(value = "bmiMeasure")
public class StudentBmiMeasure implements Measure {
	private Logger logger = Logger.getLogger(StudentBmiMeasure.class);

	@Override
	public double doMeasure(Object obj) {
		if (obj == null) {
			logger.error("错误的测量");
			throw new RuntimeException("待测数据异常");
		}
		if (!(obj instanceof Student)) {
			logger.error("错误的测量");
			throw new RuntimeException("待测数据异常");
		}
		Student stu = (Student) obj;
		return stu.getWeight() / (stu.getHeight() * stu.getHeight());
	}
}
