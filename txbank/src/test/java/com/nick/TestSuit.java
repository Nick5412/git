package com.nick;

import com.nick.txbank.Test1;
import com.nick.txbank.Test2_DataSourceConfig;
import com.nick.txbank.dao.AccountDaoJdbcTemplateImplTest;
import com.nick.txbank.dao.OpRecordDaoJdbcTemplateImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Nick
 * @Classname TestSuit
 * @Date 2023/08/02 15:35
 * @Description 测试套件
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {Test1.class, Test2_DataSourceConfig.class, AccountDaoJdbcTemplateImplTest.class, OpRecordDaoJdbcTemplateImplTest.class})
public class TestSuit {
}
