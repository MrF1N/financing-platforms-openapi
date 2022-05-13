package by.mrf1n.finance.currencycom.webclient.context.adapter;

import by.mrf1n.finance.currencycom.context.MarketContext;
import by.mrf1n.finance.currencycom.model.BlockchainAddressGetResponse;
import by.mrf1n.finance.currencycom.model.BlockchainAddressRequest;
import by.mrf1n.finance.currencycom.model.CurrencyResponse;
import by.mrf1n.finance.currencycom.model.ExchangeInfo;
import by.mrf1n.finance.currencycom.model.KLinesRequest;
import by.mrf1n.finance.currencycom.webclient.context.AdapterBaseContextImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MarketContextImpl extends AdapterBaseContextImpl implements MarketContext {

    @Autowired
    public MarketContextImpl(String authKey, String authSecret) {
        super(authKey, authSecret);
    }

    @Override
    public CurrencyResponse getListOfCurrencies() {
        return this.client.get()
                .uri(uriBuilder ->
                        this.createUriWithSignature(
                                this.buildWithTime(uriBuilder, adapterProps.getListOfCurrencies(), null)
                                        .build()
                        )
                )
                .retrieve()
                .bodyToMono(CurrencyResponse.class)
                .block();
    }

    @Override
    public BlockchainAddressGetResponse getDepositAddress(BlockchainAddressRequest request) {
        return this.client.get()
                .uri(uriBuilder ->
                        this.createUriWithSignature(
                                this.buildWithTime(uriBuilder, adapterProps.getStringOfAddress(), request.getTimestamp())
                                        .queryParamIfPresent("recvWindow", Optional.ofNullable(request.getRecvWindow()))
                                        .queryParam("coin", request.getCoin())
                                        .build()
                        )
                )
                .retrieve()
                .bodyToMono(BlockchainAddressGetResponse.class)
                .block();
    }

    @Override
    public ExchangeInfo getExchangeInfo() {
        return this.client.get().uri(adapterProps.getExchangeInfo())
                .retrieve()
                .bodyToMono(ExchangeInfo.class).block();
    }

    @Override
    public List<List<Number>> getKlines(KLinesRequest request) {
        return this.client.get()
                .uri(uriBuilder -> uriBuilder.path(adapterProps.getKlines())
                        .queryParam("symbol", request.getSymbol())
                        .queryParam("interval", request.getInterval())
                        .queryParamIfPresent("startTime", Optional.ofNullable(request.getStartTime()))
                        .queryParamIfPresent("endTime", Optional.ofNullable(request.getEndTime()))
                        .queryParamIfPresent("limit", Optional.ofNullable(request.getLimit()))
                        .queryParamIfPresent("type", Optional.ofNullable(request.getType()))
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<List<Number>>>() {
                }).block();
    }
}
