package by.mrf1n.finance.currencycom.webclient.context.adapter;

import by.mrf1n.finance.currencycom.context.TradeContext;
import by.mrf1n.finance.currencycom.model.AggTradesRequest;
import by.mrf1n.finance.currencycom.model.AggTradesResponse;
import by.mrf1n.finance.currencycom.model.DepthRequest;
import by.mrf1n.finance.currencycom.model.DepthResponse;
import by.mrf1n.finance.currencycom.webclient.context.AdapterBaseContextImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TradeContextImpl extends AdapterBaseContextImpl implements TradeContext {

    @Autowired
    public TradeContextImpl(String authKey, String authSecret) {
        super(authKey, authSecret);
    }

    @Override
    public AggTradesResponse getAggTrades(AggTradesRequest request) {
        return this.client.get()
                .uri(builder -> builder.path(this.adapterProps.getTradesAggregated())
                        .queryParam("symbol", request.getSymbol())
                        .queryParamIfPresent("startTime", Optional.ofNullable(request.getStartTime()))
                        .queryParamIfPresent("endTime", Optional.ofNullable(request.getEndTime()))
                        .queryParamIfPresent("limit", Optional.ofNullable(request.getLimit()))
                        .build()
                )
                .retrieve()
                .bodyToMono(AggTradesResponse.class)
                .block();
    }

    @Override
    public DepthResponse getOrderBook(DepthRequest request) {
        return null;
    }
}
