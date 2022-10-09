package by.mrf1n.finance.bank.nbrbby.webclient;

import by.mrf1n.finance.bank.nbrbby.context.NbRbByContext;
import by.mrf1n.finance.bank.nbrbby.model.rate.ByCodeRateRequest;
import by.mrf1n.finance.bank.nbrbby.model.rate.ByPeriodicityRateRequest;
import by.mrf1n.finance.bank.nbrbby.model.Currency;
import by.mrf1n.finance.bank.nbrbby.model.DynamicOfRateRequest;
import by.mrf1n.finance.bank.nbrbby.model.rate.Rate;
import by.mrf1n.finance.bank.nbrbby.model.RateShort;
import by.mrf1n.finance.bank.nbrbby.property.NbRbByApiProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NbRbByContextImpl implements NbRbByContext {

    private final NbRbByApiProperties nbRbByApiProperties;
    private final WebClient nbRbByWebClient;

    @Override
    public List<Currency> getAllCurrencies() {
        return this.nbRbByWebClient.get()
                .uri(this.nbRbByApiProperties.getCurrencies())
                .retrieve()
                .bodyToFlux(Currency.class)
                .collectList()
                .block();
    }

    @Override
    public Currency getCurrencyById(Integer internCurrencyId) {
        return this.nbRbByWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(this.nbRbByApiProperties.getCurrenciesById())
                        .build(Map.of("id", internCurrencyId.toString()))
                )
                .retrieve()
                .bodyToMono(Currency.class)
                .block();
    }

    @Override
    public List<Rate> getRatesByPeriodicity(ByPeriodicityRateRequest request) {
        return this.nbRbByWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(this.nbRbByApiProperties.getRates())
                        .queryParam("periodicity", request.getPeriodicity())
                        .queryParamIfPresent("ondate", Optional.ofNullable(request.getDateByNbRbFormat()))
                        .build()
                )
                .retrieve()
                .bodyToFlux(Rate.class)
                .collectList()
                .block();
    }

    @Override
    public Rate getRateByCode(ByCodeRateRequest request) {
        return this.nbRbByWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(this.nbRbByApiProperties.getRateByCode())
                        .queryParam("parammode", request.getParamMode())
                        .queryParamIfPresent("ondate", Optional.ofNullable(request.getDateByNbRbFormat()))
                        .build(Map.of("code", request.getCurrencyCode()))
                )
                .retrieve()
                .bodyToMono(Rate.class)
                .block();
    }

    @Override
    public List<RateShort> getRateByDateRange(DynamicOfRateRequest request) {
        return this.nbRbByWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(this.nbRbByApiProperties.getDynamicsOfRate())
                        .queryParam("startdate", request.getStartDateByNbRbFormat())
                        .queryParam("enddate", request.getEndDateByNbRbFormat())
                        .build(Map.of("code", request.getCurrencyId()))
                )
                .retrieve()
                .bodyToFlux(RateShort.class)
                .collectList()
                .block();
    }
}
