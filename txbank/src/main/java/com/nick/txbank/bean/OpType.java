package com.nick.txbank.bean;

/**
 * @author Nick
 * @Classname OpType
 * @Date 2023/08/03 9:26
 * @Description
 */
public enum OpType {
	WITHDRAW("withdraw", 1),
	DEPOSIT("deposit", 2),
	TRANSFER("transfer", 3);

	private String key;
	private int value;

	OpType(String key, int value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
