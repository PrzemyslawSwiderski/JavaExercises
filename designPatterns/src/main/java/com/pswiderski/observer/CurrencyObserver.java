package com.pswiderski.observer;

import java.math.BigDecimal;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public abstract class CurrencyObserver {

  public CurrencyObserver(BankAccountSummary bankAccountSummary, String currencyName,
      BigDecimal exchangeValue) {
    this.bankAccountSummary = bankAccountSummary;
    this.bankAccountSummary.attach(this);
    this.currencyName = currencyName;
    this.exchangeValue = exchangeValue;
  }

  private BankAccountSummary bankAccountSummary;

  private String currencyName;

  private BigDecimal exchangeValue;

  private BigDecimal getValueInCurrency() {
    return bankAccountSummary.getMoney().multiply(exchangeValue);
  }

  void update() {
    log.info(
        "BankAccount money in: " + this.currencyName + " is equal to: " + getValueInCurrency());
  }
}
