package com.tr.converter.convermoneynumbertotext.model.dto;

import java.util.Objects;

public class Money extends BaseDto{
	private static final long serialVersionUID = -4284468107519076009L;
	private String cents;
	private String dollars;
	private String amountText;

	@Override
	public String toString() {
		return "Money{" +
				"cents='" + cents + '\'' +
				", dollars='" + dollars + '\'' +
				", amountText='" + amountText + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Money money = (Money) o;
		return Objects.equals(cents, money.cents) &&
				Objects.equals(dollars, money.dollars) &&
				Objects.equals(amountText, money.amountText);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cents, dollars, amountText);
	}

	public String getCents() {
		return cents;
	}
	public void setCents(String cents) {
		this.cents = cents;
	}
	public String getDollars() {
		return dollars;
	}
	public void setDollars(String dollars) {
		this.dollars = dollars;
	}
	public void setAmountText(String amountText) {
		this.amountText = amountText;
	}
	public String getAmountText() {
		return amountText;
	}
	
}
