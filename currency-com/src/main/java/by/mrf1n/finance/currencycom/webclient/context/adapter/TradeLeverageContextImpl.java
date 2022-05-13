package by.mrf1n.finance.currencycom.webclient.context.adapter;

import by.mrf1n.finance.currencycom.context.TradeLeverageContext;
import by.mrf1n.finance.currencycom.model.CloseTradingPositionRequest;
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
}
