package com.pswiderski.observer;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class BankAccountSummary {

    private List<CurrencyObserver> currencyObserverList = new ArrayList<CurrencyObserver>();

    private BigDecimal money;

    public void attach(CurrencyObserver currencyObserver) {
        currencyObserverList.add(currencyObserver);
    }

    public void notifyAllCurrencyObservers() {
        for (CurrencyObserver observer : currencyObserverList) {
            observer.update();
        }
    }

}
