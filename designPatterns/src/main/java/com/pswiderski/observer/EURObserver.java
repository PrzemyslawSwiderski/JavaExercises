package com.pswiderski.observer;

import java.math.BigDecimal;

public class EURObserver extends CurrencyObserver {

  public static final String CURRENCY_NAME = "EUR";
  public static final BigDecimal EXCHANGE_VALUE = BigDecimal.valueOf(4.27);

  public EURObserver(BankAccountSummary bankAccountSummary) {
    super(bankAccountSummary, CURRENCY_NAME, EXCHANGE_VALUE);
  }
}
