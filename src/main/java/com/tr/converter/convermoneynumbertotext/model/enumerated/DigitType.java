package com.tr.converter.convermoneynumbertotext.model.enumerated;

public enum DigitType {

	BILLIONS("billions","billions"),
	MILLIONS("millions","millions"),
	HUNDRED_THOUSANDS("thousand","thousand"),
	CENT("cent","cent"),
	EMPTY("empty","");
	
	private String key;
	private String value;

	DigitType(String key, String value){
		this.setKey(key);
		this.setValue(value);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
