package com.pswiderski.observer;

import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class BankAccountSummaryTest {

  @Test
  public void notifyAllCurrencyObservers() {
    BankAccountSummary bankAccountSummary = new BankAccountSummary();
    bankAccountSummary.setMoney(BigDecimal.valueOf(56.4));
    new EURObserver(bankAccountSummary);
    new PLNObserver(bankAccountSummary);
    new GBPObserver(bankAccountSummary);
    new USDObserver(bankAccountSummary);
    log.info("Notification before change:");
    bankAccountSummary.notifyAllCurrencyObservers();

    log.info("Notification after change:");
    bankAccountSummary.setMoney(BigDecimal.valueOf(2.0));
    bankAccountSummary.notifyAllCurrencyObservers();


  }

}