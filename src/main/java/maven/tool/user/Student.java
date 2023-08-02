package maven.tool.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nick
 * @Classname Student
 * @Date 2023/07/26 9:02
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private String name;
	private double height;
	private double weight;
}
