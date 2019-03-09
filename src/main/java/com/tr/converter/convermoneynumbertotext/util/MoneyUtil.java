package com.tr.converter.convermoneynumbertotext.util;

import com.tr.converter.convermoneynumbertotext.model.dto.Money;

import java.text.DecimalFormat;

public class MoneyUtil {

	private MoneyUtil(){}
	
	private final static String POINT = ".";
	public static Money clearMoney(String moneyAmount){  //normalize
		Money money = new Money();
		moneyAmount = replacePunctuation(moneyAmount);
		setDollar(money, moneyAmount);
		setCent(money, moneyAmount);
		return money;
	}
	public static void setDollar(Money money , String moneyAmount){
		if(isPunctuationExist(moneyAmount))
			money.setDollars(maskMoney(moneyAmount.substring(0, moneyAmount.indexOf(POINT))));
		else
			money.setDollars(maskMoney(moneyAmount));
	}
	public static void setCent(Money money , String moneyAmount){
		if(isPunctuationExist(moneyAmount))
			money.setCents(moneyAmount.substring(moneyAmount.indexOf(POINT)));
		else
			money.setCents("00");
	}
	public static String replacePunctuation(String moneyAmount){
		if(isPunctuationExist(moneyAmount))
			return moneyAmount.replace(",", ".");
		return moneyAmount;
	}
	
	public static String maskMoney(String moneyAmount){
		String mask = "000000000000";
		DecimalFormat df = new DecimalFormat(mask);
		return df.format(Long.parseLong(moneyAmount));
	}

	public static boolean isPunctuationExist(String moneyAmount){
		if(moneyAmount.contains(".") || moneyAmount.contains(","))
			return true;
		return false;
	}
}
