package maven.tool.system;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nick
 * @Classname ToolBox
 * @Date 2023/07/26 8:35
 * @Description TODO
 */
@Component
public class ToolBox<T> {
	private List<T> objs = new ArrayList<>();
	@Resource(name = "bmiMeasure")
	private Measure measure;
	@Resource(name = "bmiFilter")
	private ContainerFilter filter;

	private T max;
	private T min;
	private double avg;
	private double sum;

	/**
	 * 添加对象
	 *
	 * @param t
	 */
	public void add(T t) {
		//	判断t是否合格,调用筛选实现
		if (filter != null) {
			if (!filter.doFilter(t)) {
				return;
			}
		}
		//	添加到objs
		objs.add(t);
		//	记录max,min,计算avg,调用measure实现
		if (objs.size() == 1) {
			max = t;
			min = t;
		} else {
			double curVal = measure.doMeasure(t);
			double maxVal = measure.doMeasure(max);
			double minVal = measure.doMeasure(min);
			if (curVal > maxVal) {
				max = t;
			}
			if (curVal < minVal) {
				min = t;
			}
		}
		sum += measure.doMeasure(t);
		avg = sum / objs.size();
	}

	/**
	 * 返回有效测量对象
	 *
	 * @return
	 */
	public int size() {
		return objs.size();
	}

	/**
	 * 系统复位
	 */
	public void clearAll() {
		objs = new ArrayList<>();
		measure = null;
		filter = null;
		max = null;
		min = null;
		avg = 0;
	}

	public T getMax() {
		return max;
	}

	public void setMax(T max) {
		this.max = max;
	}

	public T getMin() {
		return min;
	}

	public void setMin(T min) {
		this.min = min;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
}
