package com.github.mrf1n.finance.walutomatpl.context;

import com.github.mrf1n.finance.walutomatpl.model.BankOffer;
import com.github.mrf1n.finance.walutomatpl.model.CurrencyRate;
import com.github.mrf1n.finance.walutomatpl.model.ExchangeOffers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WebClientWalutomatPlPublicApiContext implements WalutomatPlPublicApiContext {

    private final WebClient walutomatPlPublicWebClient;

    @Override
    public List<CurrencyRate> getCurrencyRates() {
        return this.walutomatPlPublicWebClient.get()
                .uri("marketBrief")
                .retrieve()
                .bodyToFlux(CurrencyRate.class)
                .collectList()
                .block();
    }

    @Override
    public CurrencyRate getCurrencyRate(String pairId) {
        return this.walutomatPlPublicWebClient.get()
                .uri("marketBrief/{pairName}",
                        Map.of("pairName", pairId))
                .retrieve()
                .bodyToMono(CurrencyRate.class)
                .block();
    }

    @Override
    public BankOffer getBuyRate(String from, String to, Double amount) {
        Optional<ExchangeOffers> offers = Optional.ofNullable(this.walutomatPlPublicWebClient.get()
                .uri("marketEstimate/buy/{amount}/{to}/{from}",
                        Map.of("amount", amount, "to", to, "from", from))
                .retrieve()
                .bodyToMono(ExchangeOffers.class)
                .block());
        return offers
                .map(ExchangeOffers::getExchangeOffers)
                .orElse(Collections.emptyList())
                .get(0);
    }

    @Override
    public BankOffer getSellRate(String from, String to, Double amount) {
        Optional<ExchangeOffers> offers = Optional.ofNullable(this.walutomatPlPublicWebClient.get()
                .uri("marketEstimate/sell/{amount}/{to}/{from}",
                        Map.of("amount", amount, "to", to, "from", from))
                .retrieve()
                .bodyToMono(ExchangeOffers.class)
                .block());
        return offers
                .map(ExchangeOffers::getExchangeOffers)
                .orElse(Collections.emptyList())
                .get(0);
    }
}
