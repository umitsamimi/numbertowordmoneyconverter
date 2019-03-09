package com.tr.converter.convermoneynumbertotext.response;

import com.tr.converter.convermoneynumbertotext.model.dto.Money;

public class MoneyResponse extends BaseResponse {
    private Money money;

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }
}
