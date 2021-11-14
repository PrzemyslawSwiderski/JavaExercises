package com.pswiderski.observer;

import java.math.BigDecimal;

public class USDObserver extends CurrencyObserver {

    public static final String CURRENCY_NAME = "USD";
    public static final BigDecimal EXCHANGE_VALUE = BigDecimal.valueOf(3.56);


    public USDObserver(BankAccountSummary bankAccountSummary) {
        super(bankAccountSummary, CURRENCY_NAME, EXCHANGE_VALUE);
    }
}
