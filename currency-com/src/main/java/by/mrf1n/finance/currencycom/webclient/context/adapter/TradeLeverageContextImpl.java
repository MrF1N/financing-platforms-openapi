package by.mrf1n.finance.currencycom.webclient.context.adapter;

import by.mrf1n.finance.currencycom.context.TradeLeverageContext;
import by.mrf1n.finance.currencycom.model.CloseTradingPositionRequest;
import by.mrf1n.finance.currencycom.model.LeverageSettingsRequest;
import by.mrf1n.finance.currencycom.model.LeverageSettingsResponse;
import by.mrf1n.finance.currencycom.model.TradingPositionCloseAllResponse;
import by.mrf1n.finance.currencycom.webclient.context.AdapterBaseContextImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TradeLeverageContextImpl extends AdapterBaseContextImpl implements TradeLeverageContext {

    @Autowired
    public TradeLeverageContextImpl(String authKey, String authSecret) {
        super(authKey, authSecret);
    }

    @Override
    public TradingPositionCloseAllResponse closeTradingPosition(CloseTradingPositionRequest request) {
        return this.client.post()
                .uri(uriBuilder ->
                        this.createUriWithSignature(
                                this.buildWithTime(uriBuilder, adapterProps.getTradingPositionClose(), request.getTimestamp())
                                        .queryParamIfPresent("recvWindow", Optional.ofNullable(request.getRecvWindow()))
                                        .queryParamIfPresent("positionId", Optional.ofNullable(request.getPositionId()))
                                        .build()
                        )
                )
                .retrieve()
                .bodyToMono(TradingPositionCloseAllResponse.class)
                .block();
    }

    @Override
    public LeverageSettingsResponse getLeverageSettings(LeverageSettingsRequest request) {
        return this.client.get()
                .uri(uriBuilder ->
                        this.createRawUriWithSignature(
                                this.buildWithTime(this.disableEncoding(uriBuilder),
                                                adapterProps.getLeverageSettings(), request.getTimestamp())
                                        .queryParam("symbol", request.getSymbol())
                                        .queryParamIfPresent("recvWindow", Optional.ofNullable(request.getRecvWindow()))
                                        .build()
                        )
                )
                .retrieve()
                .bodyToMono(LeverageSettingsResponse.class)
                .block();
    }
}
