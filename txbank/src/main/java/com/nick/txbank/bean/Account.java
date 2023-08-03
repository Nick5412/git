package com.nick.txbank.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Nick
 * @Classname Account
 * @Date 2023/08/03 9:25
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account implements Serializable {
	private int accountid;
	private double money;
}
