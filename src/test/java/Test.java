import org.junit.Assert;
import org.junit.Before;

/**
 * @author Nick
 * @Classname StudentBmiMeasure
 * @Date 2023/07/21 20:57
 * @Description TODO
 */
public class Test {

	private Calculate calculate;

	@Before
	public void before() {
		calculate = new Calculate();
	}

	@org.junit.Test
	public void testAdd() {
		Assert.assertEquals(calculate.add(1, 2), 3);
	}
}
