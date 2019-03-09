package com.tr.converter.convermoneynumbertotext.model.enumerated;

import java.util.Arrays;

public enum ZeroToNineteen {

	ZERO		(0,""),
	ONE			(1,"one"),
	TWO			(2,"two"),
	THREE		(3,"three"),
	FOUR		(4,"four"),
	FIVE		(5,"five"),
	SIX			(6,"six"),
	SEVEN		(7,"seven"),
	EIGHT		(8,"eight"),
	NINE		(9,"nine"),
	TEN			(10,"ten"),
	ELEVEN		(11,"eleven"),
	TWELVE		(12,"twelve"),
	THIRTEEN	(13,"thirteen"),
	FOURTEEN	(14,"fourteen"),
	FIFTEEN		(15,"fifteen"),
	SIXTEEN		(16,"sixteen"),
	SEVENTEEN	(17,"seventeen"),
	EIGHTEEN	(18,"eighteen"),
	NINETEEN	(19,"nineteen");
	
	private int key;
	private String value;

	ZeroToNineteen(int key, String value){
		this.key = key;
		this.value = value;
	}

	public static String getValueFromKey(int key){
		return Arrays.stream(ZeroToNineteen.values())
				.filter(item-> item.getKey() == key)
				.map(ZeroToNineteen::getValue).reduce("", String::concat);
	}
	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
}
