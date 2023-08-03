package com.nick.txbank.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Nick
 * @Classname OpRecord
 * @Date 2023/08/03 9:28
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OpRecord implements Serializable {
	private int id;
	private int accountid;
	private double opmoney;
	//datetime => String
	private String optime;
	private OpType optype;
	private Integer transferid;
}
