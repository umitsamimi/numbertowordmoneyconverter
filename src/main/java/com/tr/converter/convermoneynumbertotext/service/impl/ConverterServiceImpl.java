package com.tr.converter.convermoneynumbertotext.service.impl;

import com.tr.converter.convermoneynumbertotext.model.dto.Money;
import com.tr.converter.convermoneynumbertotext.request.ConvertRequest;
import com.tr.converter.convermoneynumbertotext.response.MoneyResponse;
import com.tr.converter.convermoneynumbertotext.service.ConverterService;
import com.tr.converter.convermoneynumbertotext.util.MoneyBuilder;
import com.tr.converter.convermoneynumbertotext.util.MoneyCalculater;
import com.tr.converter.convermoneynumbertotext.util.MoneyUtil;
import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl implements ConverterService {

	public MoneyResponse convertMoneyToWord(ConvertRequest request){
		MoneyResponse response = new MoneyResponse();
		Money money = MoneyUtil.clearMoney(request.getMoneyAmount());

		MoneyBuilder moneyBuilder = new MoneyBuilder.Builder()
				.setBillions(MoneyCalculater.getBillions(money.getDollars()))
				.setMillions(MoneyCalculater.getMillions(money.getDollars()))
				.setHundredThousands(MoneyCalculater.gethundredThousands(money.getDollars()))
				.setThousands(MoneyCalculater.getThousand(money.getDollars()))
				.setCent(MoneyCalculater.getCent(money.getCents()))
				.build();
		money.setAmountText(moneyBuilder.getAllText());
		response.setMoney(money);
		return response;
	}
}
