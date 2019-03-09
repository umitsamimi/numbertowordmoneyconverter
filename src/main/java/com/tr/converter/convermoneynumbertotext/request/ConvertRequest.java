package com.tr.converter.convermoneynumbertotext.request;

import javax.validation.constraints.NotNull;

public class ConvertRequest extends BaseRequest{

	private static final long serialVersionUID = -1293123103361704529L;
	
	@NotNull
	private String moneyAmount;

	public String getMoneyAmount() {
		return moneyAmount;
	}

	public void setMoneyAmount(String moneyAmount) {
		this.moneyAmount = moneyAmount;
	}
}
