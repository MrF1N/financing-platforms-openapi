package by.mrf1n.finance.currencycom.webclient.context;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class MarketTokenContextImpl extends MarketCapContextImpl{

    public MarketTokenContextImpl(String authKey, String authSecret, WebClient marketTokenWebClient) {
        super(authKey, authSecret, marketTokenWebClient);
    }
}
