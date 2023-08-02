package maven.tool.system;

/**
 * @author Nick
 * @Classname ContainerFilter
 * @Date 2023/07/26 8:49
 * @Description TODO
 */
public interface ContainerFilter {
	//判断此对象是否为有效对象
	boolean doFilter(Object obj);
}
