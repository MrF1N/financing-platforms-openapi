package com.github.mrf1n.finance.walutomatpl;

import com.github.mrf1n.finance.walutomatpl.context.WebClientWalutomatPlPublicApiContext;
import com.github.mrf1n.finance.walutomatpl.model.BankOffer;
import com.github.mrf1n.finance.walutomatpl.model.CurrencyRate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import java.util.List;

@ContextConfiguration(classes = {WalutomatPlOpenApiTestConfig.class})
@SpringBootTest
public class WebClientWalutomatPlPublicApiContextTest {

    @Autowired
    private WebClientWalutomatPlPublicApiContext webClientWalutomatPlPublicApiContext;

    @Test
    public void getCurrencyRatesTest() {
        List<CurrencyRate> currencyRates = webClientWalutomatPlPublicApiContext.getCurrencyRates();
        System.out.println(currencyRates);
        Assert.notEmpty(currencyRates, "ListOfAssets is empty");

    }

    @Test
    public void getCurrencyRateByPairIdTest() {
        String pairName = "USD_PLN";
        CurrencyRate rate = webClientWalutomatPlPublicApiContext.getCurrencyRate(pairName);
        System.out.println(rate);
        Assert.notNull(rate, "Rate is null");

    }

    @Test
    public void getBuyOfferTest() {
        String from = "USD";
        String to = "PLN";
        Double amount = 100.0;
        BankOffer offer = webClientWalutomatPlPublicApiContext.getBuyRate(from, to, amount);
        System.out.println(offer);
        Assert.notNull(offer, "Offer is null");
    }

    @Test
    public void getSellOfferTest() {
        String from = "USD";
        String to = "PLN";
        Double amount = 100.0;
        BankOffer offer = webClientWalutomatPlPublicApiContext.getSellRate(from, to, amount);
        System.out.println(offer);
        Assert.notNull(offer, "Offer is null");
    }
}
