package com.nick.txbank;

import com.alibaba.druid.pool.DruidDataSource;
import com.nick.txbank.configs.Config;
import com.nick.txbank.configs.DataSourceConfig;
import junit.framework.TestCase;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Nick
 * @Classname Test2_DataSourceConfig
 * @Date 2023/08/02 15:09
 * @Description TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class, DataSourceConfig.class})
@Log4j2
public class Test2_DataSourceConfig extends TestCase {
	@Autowired
	private DataSourceConfig dsc;

	@Autowired
	private Environment env;

	@Autowired
	@Qualifier("jdbcDataSource")
	private DataSource jdbc;

	@Autowired
	@Qualifier("dbcpDataSource")
	private DataSource dbcp;

	@Autowired
	@Qualifier("druidDataSource")
	private DataSource druid;

	@Test
	public void testPropertySource() {
		Assert.assertEquals("root", dsc.getUsername());
		// log.info(dsc.getUsername());
	}

	@Test
	public void testEnvironment() {
		log.info(env.getProperty("jdbc.password") + "\t" + env.getProperty("user.home"));
	}

	@Test
	public void testJDBCConnection() throws SQLException {
		Assert.assertNotNull(jdbc.getConnection());
		Connection conn = jdbc.getConnection();
		log.info(conn);
	}

	@Test
	public void testDBCPConnection() throws SQLException {
		Assert.assertNotNull(dbcp.getConnection());
		Connection conn = dbcp.getConnection();
		log.info(conn);
	}

	@Test
	public void testDRUIDConnection() throws SQLException {
		Assert.assertNotNull(druid.getConnection());
		Connection conn = druid.getConnection();
		log.info(conn + "\t" + ((DruidDataSource) druid).getInitialSize());
	}
}
