package com.nick.txbank.dao;

import com.nick.txbank.bean.OpRecord;
import com.nick.txbank.bean.OpType;
import com.nick.txbank.configs.Config;
import com.nick.txbank.configs.DataSourceConfig;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Nick
 * @Classname OpRecordDaoJdbcTemplateImplTest
 * @Date 2023/08/03 10:40
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class, DataSourceConfig.class})
@Log4j2
public class OpRecordDaoJdbcTemplateImplTest {

	@Autowired
	private OpRecordDao opRecordDao;

	@Test
	public void insertOpRecord() {
		OpRecord opRecord = new OpRecord();
		opRecord.setAccountid(1);
		opRecord.setOpmoney(10);
		opRecord.setOptime("2023-08-03 11:47:09");
		opRecord.setOptype(OpType.DEPOSIT);
		opRecordDao.insertOpRecord(opRecord);
	}

	@Test
	public void findOpRecord() {
		List<OpRecord> list = opRecordDao.findOpRecord(1);
		log.info(list);
		for (OpRecord opRecord : list) {
			System.out.println(opRecord.getId() + "\t" + opRecord.getAccountid() + "\t" + opRecord.getOpmoney());
		}
	}

	@Test
	public void testFindOpRecord() {
		List<OpRecord> list = opRecordDao.findOpRecord(1, "deposit");
		log.info(list);
		for (OpRecord opRecord : list) {
			System.out.println(opRecord.getId() + "\t" + opRecord.getAccountid() + "\t" + opRecord.getOpmoney());
		}
	}

	@Test
	public void testFindOpRecord1() {
	}
}