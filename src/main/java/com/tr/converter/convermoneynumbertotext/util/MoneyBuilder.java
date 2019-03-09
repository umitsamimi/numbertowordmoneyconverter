package com.tr.converter.convermoneynumbertotext.util;

import com.tr.converter.convermoneynumbertotext.model.enumerated.DigitType;

public class MoneyBuilder {
	private final static String SPACE = " ";
	private String dollarText;
	private String centText;
	private String allText;
	
	public static class Builder{
		private int billions;
		private int millions;
		private int hundredThousands;
		private int thousands;
		private int cent;
		
		public Builder(){}
		
		public Builder setBillions(int billions){
			this.billions = billions;
			return this;
		}
		
		public Builder setMillions(int millions){
			this.millions = millions;
			return this;
		}
		
		public Builder setHundredThousands(int hundredThousands){
			this.hundredThousands = hundredThousands;
			return this;
		}
		
		public Builder setThousands(int thousands){
			this.thousands = thousands;
			return this;
		}

		public Builder setCent(int cent){
			this.cent = cent;
			return this;
		}
		
		public MoneyBuilder build(){
			return new MoneyBuilder(this);
		}
	}
	
	private MoneyBuilder(Builder builder){

		dollarText = MoneyCalculater.getAmountText(builder.billions, DigitType.BILLIONS) 							+ SPACE
						+MoneyCalculater.getAmountText(builder.millions, DigitType.MILLIONS) 						+ SPACE
						+MoneyCalculater.getAmountText(builder.hundredThousands, DigitType.HUNDRED_THOUSANDS) 	+ SPACE
						+MoneyCalculater.getAmountText(builder.thousands, DigitType.EMPTY);

		centText  = MoneyCalculater.getAmountText(builder.cent, DigitType.CENT);
		prepareAllAmountText(centText);
		allText = allText.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", SPACE);
	}

	private void prepareAllAmountText(String centText){
		if(isCentExist(centText))
			allText = dollarText + " dolar and "+ centText;
		else
			allText = dollarText + "dolar";
	}

	private boolean isCentExist(String centText){
		if(centText.length()>0)
			return true;
		return false;
	}

	public String getAllText() {
		return allText;
	}
}
