package com.tr.converter.convermoneynumbertotext.util;

import com.tr.converter.convermoneynumbertotext.model.enumerated.DigitType;
import com.tr.converter.convermoneynumbertotext.model.enumerated.Tens;
import com.tr.converter.convermoneynumbertotext.model.enumerated.ZeroToNineteen;

public class MoneyCalculater {

	public static String getAmountText(int amount, DigitType type){
		if(amount == 0)
			return "";
		if(amount == 1)
			return " one "+type.getValue();
		return getAmountText(amount)+ " " +type.getValue();
	}

	private static String getAmountText(int amount){
		String amountText = "";
		if (amountIsInZeroToNineTeen(amount)){
			amountText = ZeroToNineteen.getValueFromKey(amount % 100);
			amount /= 100;
		}else{
			amountText = ZeroToNineteen.getValueFromKey(amount % 10);
			amount  /= 10;

			amountText = Tens.getValueFromKey(amount % 10) +" " + amountText;
			amount  /= 10;
		}
		if (amount == 0)
			return amountText;

		return ZeroToNineteen.getValueFromKey(amount) + " hundred " + amountText;
	}

	public static int getBillions(String amount){
		return Integer.parseInt(amount.substring(0, 3));
	}
	
	public static int getMillions(String amount){
		return Integer.parseInt(amount.substring(3, 6));
	}
	
	public static int gethundredThousands(String amount){
		return Integer.parseInt(amount.substring(6, 9));
	}
	
	public static int getThousand(String amount){
		return Integer.parseInt(amount.substring(9, 12));
	}

	public static int getCent(String amount){
		return Integer.parseInt(amount.substring(1));
	}


	private static boolean amountIsInZeroToNineTeen(int amount){
		if(amount % 100  < 20)
			return true;
		return false;
	}

}
