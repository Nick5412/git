package maven.tool.system;

/**
 * @author Nick
 * @Classname Measure
 * @Date 2023/07/26 8:49
 * @Description TODO
 */
public interface Measure {
	/**
	 * @param obj 待测量对象
	 * @return 测量的值
	 */
	double doMeasure(Object obj);
}
