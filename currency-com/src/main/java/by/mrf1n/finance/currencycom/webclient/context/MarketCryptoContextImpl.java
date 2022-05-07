package by.mrf1n.finance.currencycom.webclient.context;

import by.mrf1n.finance.currencycom.model.enums.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Component
public class MarketCryptoContextImpl extends MarketCapContextImpl {

    @Autowired
    public MarketCryptoContextImpl(String authKey, String authSecret, WebClient marketCryptoWebClient) {
        super(authKey, authSecret, marketCryptoWebClient);
    }

    @Override
    public List<List<Number>> getCandlesData(String symbol, Interval interval,
                                             BigInteger startTime, BigInteger endTime,
                                             Integer limit) {
        return this.client.get()
                .uri(uriBuilder -> uriBuilder.path(marketProperties.getCandlesData())
                        .queryParamIfPresent("symbol", Optional.ofNullable(symbol))
                        .queryParamIfPresent("interval", Optional.ofNullable(interval == null? null: interval.getCandlesInterval()))
                        .queryParamIfPresent("startTime", Optional.ofNullable(startTime))
                        .queryParamIfPresent("endTime", Optional.ofNullable(endTime))
                        .queryParamIfPresent("limit", Optional.ofNullable(limit))
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<List<Number>>>() {})
                .block();
    }
}
