package maven.dbhelper;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Nick
 * @Classname Config
 * @Date 2023/07/26 11:17
 * @Description TODO
 */
@Configuration
@ComponentScan(value = "maven.dbhelper")
//查找资源文件
@PropertySource(value = "classpath:db.properties")
public class Config {
}
