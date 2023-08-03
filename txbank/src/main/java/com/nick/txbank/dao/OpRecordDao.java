package com.nick.txbank.dao;

import com.nick.txbank.bean.OpRecord;

import java.util.List;

/**
 * @author Nick
 * @Classname OpRecordDao
 * @Date 2023/08/03 9:32
 * @Description
 */
public interface OpRecordDao {
	/**
	 * 日志添加
	 *
	 * @param opRecord
	 */
	void insertOpRecord(OpRecord opRecord);

	/**
	 * 查询一个用户的所有日志,根据时间排序
	 *
	 * @param accountid
	 * @return
	 */
	List<OpRecord> findOpRecord(int accountid);

	/**
	 * 查询accountid账户的opType类型,根据时间排序
	 *
	 * @param accountid
	 * @param opType
	 * @return
	 */
	List<OpRecord> findOpRecord(int accountid, String opType);

	/**
	 * @param opRecord
	 * @return
	 */
	List<OpRecord> findOpRecord(OpRecord opRecord);

}
