package com.github.mrf1n.finance.walutomatpl.context;

import com.github.mrf1n.finance.walutomatpl.model.BankOffer;
import com.github.mrf1n.finance.walutomatpl.model.CurrencyRate;

import java.util.List;

public interface WalutomatPlPublicApiContext {

    List<CurrencyRate> getCurrencyRates();

    CurrencyRate getCurrencyRate(String pairId);

    BankOffer getBuyRate(String from, String to, Double amount);

    BankOffer getSellRate(String from, String to, Double amount);
}
