package com.github.mrf1n.finance.walutomatpl.context;

import com.github.mrf1n.finance.walutomatpl.configuration.WalutomatPlPublicApiProperties;
import com.github.mrf1n.finance.walutomatpl.model.CurrencyRate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class WebClientWalutomatPlPublicApiContext implements WalutomatPlPublicApiContext {

    private final WalutomatPlPublicApiProperties apiProperties;
    private final WebClient walutomatPlWebClient;

    @Override
    public List<CurrencyRate> getCurrencyRates() {
        return this.walutomatPlWebClient.get()
                .uri(this.apiProperties.getCurrencies())
                .retrieve()
                .bodyToFlux(CurrencyRate.class)
                .collectList()
                .block();
    }

    @Override
    public CurrencyRate getCurrencyRateByPairId(String pairId) {
        return this.walutomatPlWebClient.get()
                .uri(this.apiProperties.getCurrency(),
                        Map.of("pairName", pairId))
                .retrieve()
                .bodyToMono(CurrencyRate.class)
                .block();
    }
}
