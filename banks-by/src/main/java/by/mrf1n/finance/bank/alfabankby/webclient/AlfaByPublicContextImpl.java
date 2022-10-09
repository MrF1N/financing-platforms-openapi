package by.mrf1n.finance.bank.alfabankby.webclient;

import by.mrf1n.finance.bank.alfabankby.context.AlfaByPublicContext;
import by.mrf1n.finance.bank.alfabankby.model.BankListRequest;
import by.mrf1n.finance.bank.alfabankby.model.BankListResponse;
import by.mrf1n.finance.bank.alfabankby.model.NationalRateListRequest;
import by.mrf1n.finance.bank.alfabankby.model.NationalRateListResponse;
import by.mrf1n.finance.bank.alfabankby.model.RateListResponse;
import by.mrf1n.finance.bank.alfabankby.property.AlfaBankByApiProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AlfaByPublicContextImpl implements AlfaByPublicContext {

    private final AlfaBankByApiProperties alfaBankByApiProperties;
    private final WebClient alfaBankByWebClient;

    @Override
    public BankListResponse getBankList(BankListRequest request) {
        return this.alfaBankByWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(this.alfaBankByApiProperties.getBankCode())
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
        return this.alfaBankByWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(this.alfaBankByApiProperties.getNationalRates())
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
        return this.alfaBankByWebClient.get()
                .uri(this.alfaBankByApiProperties.getNationalRates())
                .retrieve()
                .bodyToMono(RateListResponse.class)
                .block();
    }
}
