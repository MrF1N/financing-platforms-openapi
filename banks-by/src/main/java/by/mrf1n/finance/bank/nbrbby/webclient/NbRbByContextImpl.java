package by.mrf1n.finance.bank.nbrbby.webclient;

import by.mrf1n.finance.bank.nbrbby.context.NbRbByContext;
import by.mrf1n.finance.bank.nbrbby.model.rate.ByCodeRateRequest;
import by.mrf1n.finance.bank.nbrbby.model.rate.ByPeriodicityRateRequest;
import by.mrf1n.finance.bank.nbrbby.model.Currency;
import by.mrf1n.finance.bank.nbrbby.model.DynamicOfRateRequest;
import by.mrf1n.finance.bank.nbrbby.model.rate.Rate;
import by.mrf1n.finance.bank.nbrbby.model.RateShort;
import by.mrf1n.finance.bank.nbrbby.property.NbRbByApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class NbRbByContextImpl implements NbRbByContext {

    private NbRbByApiProperties properties;
    private WebClient client;

    @Override
    public List<Currency> getAllCurrencies() {
        return this.client.get()
                .uri(this.properties.getCurrencies())
                .retrieve()
                .bodyToFlux(Currency.class)
                .collectList()
                .block();
    }

    @Override
    public Currency getCurrencyById(Integer internCurrencyId) {
        return this.client.get()
                .uri(uriBuilder -> uriBuilder
                        .path(this.properties.getCurrenciesById())
                        .build(Map.of("id", internCurrencyId.toString()))
                )
                .retrieve()
                .bodyToMono(Currency.class)
                .block();
    }

    @Override
    public List<Rate> getRatesByPeriodicity(ByPeriodicityRateRequest request) {
        return this.client.get()
                .uri(uriBuilder -> uriBuilder
                        .path(this.properties.getRates())
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
        return this.client.get()
                .uri(uriBuilder -> uriBuilder
                        .path(this.properties.getRateByCode())
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
        return this.client.get()
                .uri(uriBuilder -> uriBuilder
                        .path(this.properties.getDynamicsOfRate())
                        .queryParam("startdate", request.getStartDateByNbRbFormat())
                        .queryParam("enddate", request.getEndDateByNbRbFormat())
                        .build(Map.of("code", request.getCurrencyId()))
                )
                .retrieve()
                .bodyToFlux(RateShort.class)
                .collectList()
                .block();
    }

    @Autowired
    public void setNbRbByApiProperties(NbRbByApiProperties nbRbByApiProperties) {
        this.properties = nbRbByApiProperties;
    }

    @Autowired
    public void setNbRbByWebClient(WebClient nbRbByWebClient) {
        this.client = nbRbByWebClient;
    }
}
