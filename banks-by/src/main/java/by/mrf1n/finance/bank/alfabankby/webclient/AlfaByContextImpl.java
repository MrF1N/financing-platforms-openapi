package by.mrf1n.finance.bank.alfabankby.webclient;

import by.mrf1n.finance.bank.alfabankby.context.AlfaByPublicContext;
import by.mrf1n.finance.bank.alfabankby.model.BankListRequest;
import by.mrf1n.finance.bank.alfabankby.model.BankListResponse;
import by.mrf1n.finance.bank.alfabankby.model.NationalRateListRequest;
import by.mrf1n.finance.bank.alfabankby.model.NationalRateListResponse;
import by.mrf1n.finance.bank.alfabankby.model.RateListResponse;
import by.mrf1n.finance.bank.alfabankby.property.AlfaBankByApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Component
public class AlfaByContextImpl implements AlfaByPublicContext {

    private AlfaBankByApiProperties properties;
    private WebClient client;

    @Override
    public BankListResponse getBankList(BankListRequest request) {
        return this.client.get()
                .uri(uriBuilder -> uriBuilder
                        .path(this.properties.getBankCode())
                        .queryParam("type",request.getType())
                        .queryParamIfPresent("search", Optional.ofNullable(request.getSearch()))
                        .queryParamIfPresent("pageNo", Optional.ofNullable(request.getPageNo()))
                        .queryParamIfPresent("pageRowCount", Optional.ofNullable(request.getPageRowCount()))
                        .build()
                )
                .retrieve()
                .bodyToMono(BankListResponse.class)
                .block();
    }

    @Override
    public NationalRateListResponse getNationalRateList(NationalRateListRequest request) {
        return this.client.get()
                .uri(uriBuilder -> uriBuilder
                        .path(this.properties.getNationalRates())
                        .queryParamIfPresent("date", Optional.ofNullable(request.getDateByAlfaFormat()))
                        .queryParamIfPresent("currencyCode", Optional.ofNullable(request.getCodesSeparatedByComma()))
                        .build()
                )
                .retrieve()
                .bodyToMono(NationalRateListResponse.class)
                .block();
    }

    @Override
    public RateListResponse getBankRateList() {
        return this.client.get()
                .uri(this.properties.getNationalRates())
                .retrieve()
                .bodyToMono(RateListResponse.class)
                .block();
    }

    @Autowired
    public void setAlfaBankByApiProperties(AlfaBankByApiProperties alfaBankByApiProperties) {
        this.properties = alfaBankByApiProperties;
    }

    @Autowired
    public void setWebClient(WebClient alfaBankByWebClient) {
        this.client = alfaBankByWebClient;
    }
}
