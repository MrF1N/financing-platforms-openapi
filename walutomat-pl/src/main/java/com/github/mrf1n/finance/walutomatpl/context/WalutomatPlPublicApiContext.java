package com.github.mrf1n.finance.walutomatpl.context;

import com.github.mrf1n.finance.walutomatpl.model.CurrencyRate;

import java.util.List;

public interface WalutomatPlPublicApiContext {

    List<CurrencyRate> getCurrencyRates();

    CurrencyRate getCurrencyRateByPairId(String pairId);
}
