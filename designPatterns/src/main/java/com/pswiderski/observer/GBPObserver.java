package com.pswiderski.observer;

import java.math.BigDecimal;

public class GBPObserver extends CurrencyObserver {

    public static final String CURRENCY_NAME = "GBP";
    public static final BigDecimal EXCHANGE_VALUE = BigDecimal.valueOf(4.83);


    public GBPObserver(BankAccountSummary bankAccountSummary) {
        super(bankAccountSummary, CURRENCY_NAME, EXCHANGE_VALUE);
    }
}
