package by.mrf1n.finance.currencycom.webclient.context;

import by.mrf1n.finance.currencycom.model.DepthOrderBookResponse;
import by.mrf1n.finance.currencycom.model.OHLCResponse;
import by.mrf1n.finance.currencycom.model.enums.Interval;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.naming.OperationNotSupportedException;
import java.math.BigInteger;
import java.util.Optional;

@Component
public class MarketTokenCryptoContextImpl extends MarketCapContextImpl{

    public MarketTokenCryptoContextImpl(String authKey, String authSecret, WebClient marketTokenCryptoWebClient) {
        super(authKey, authSecret, marketTokenCryptoWebClient);
    }

    @Override
    public OHLCResponse getOHLC(String symbol, Interval interval, BigInteger since) {
        return this.client.get()
                .uri(builder -> builder.path(this.marketProperties.getOHLC())
                        .queryParamIfPresent("symbol", Optional.ofNullable(symbol))
                        .queryParamIfPresent("interval", Optional.ofNullable(interval))
                        .queryParamIfPresent("since", Optional.ofNullable(since))
                        .build()
                )
                .retrieve()
                .bodyToMono(OHLCResponse.class)
                .block();
    }
}
