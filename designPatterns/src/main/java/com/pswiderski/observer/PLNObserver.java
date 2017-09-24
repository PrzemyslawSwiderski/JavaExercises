package com.pswiderski.observer;


import java.math.BigDecimal;

public class PLNObserver extends CurrencyObserver {

  public static final String CURRENCY_NAME = "PLN";
  public static final BigDecimal EXCHANGE_VALUE = BigDecimal.valueOf(1.0);

  public PLNObserver(BankAccountSummary bankAccountSummary) {
    super(bankAccountSummary, CURRENCY_NAME, EXCHANGE_VALUE);
  }
}
