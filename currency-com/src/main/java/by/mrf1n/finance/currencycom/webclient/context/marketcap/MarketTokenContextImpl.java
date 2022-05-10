package by.mrf1n.finance.currencycom.webclient.context.marketcap;

import by.mrf1n.finance.currencycom.webclient.context.MarketCapContextImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class MarketTokenContextImpl extends MarketCapContextImpl {

    @Autowired
    public void setClient(WebClient marketTokenWebClient) {
        this.client = marketTokenWebClient;
    }
}
