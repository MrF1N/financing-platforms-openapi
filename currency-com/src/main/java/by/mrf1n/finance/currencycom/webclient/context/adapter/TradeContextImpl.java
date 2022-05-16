package by.mrf1n.finance.currencycom.webclient.context.adapter;

import by.mrf1n.finance.currencycom.context.TradeContext;
import by.mrf1n.finance.currencycom.model.AggTradesRequest;
import by.mrf1n.finance.currencycom.model.AggTradesResponse;
import by.mrf1n.finance.currencycom.model.AllMyTradesRequest;
import by.mrf1n.finance.currencycom.model.CancelOrderRequest;
import by.mrf1n.finance.currencycom.model.CancelOrderResponse;
import by.mrf1n.finance.currencycom.model.CreateOrderRequest;
import by.mrf1n.finance.currencycom.model.DepthRequest;
import by.mrf1n.finance.currencycom.model.DepthResponse;
import by.mrf1n.finance.currencycom.model.GetOrderDtoResponse;
import by.mrf1n.finance.currencycom.model.GetOrderRequest;
import by.mrf1n.finance.currencycom.model.MyTradesResponse;
import by.mrf1n.finance.currencycom.model.NewOrderResponse;
import by.mrf1n.finance.currencycom.model.PositionHistoryRequest;
import by.mrf1n.finance.currencycom.model.QueryOrderResponse;
import by.mrf1n.finance.currencycom.model.SignedBySymbolRequest;
import by.mrf1n.finance.currencycom.model.TradingPositionHistoryResponse;
import by.mrf1n.finance.currencycom.model.TransactionsRequest;
import by.mrf1n.finance.currencycom.model.TransactionsResponse;
import by.mrf1n.finance.currencycom.webclient.context.AdapterBaseContextImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
        return this.client.get()
                .uri(builder -> builder.path(this.adapterProps.getOrderBook())
                        .queryParam("symbol", request.getSymbol())
                        .queryParamIfPresent("limit", Optional.ofNullable(request.getLimit()))
                        .build()
                )
                .retrieve()
                .bodyToMono(DepthResponse.class)
                .block();
    }

    @Override
    public GetOrderDtoResponse getOrder(GetOrderRequest request) {
        return this.client.get()
                .uri(uriBuilder ->
                        this.createRawUriWithSignature(
                                this.buildWithTime(this.disableEncoding(uriBuilder),
                                                adapterProps.getOrder(), request.getTimestamp())
                                        .queryParam("orderId", request.getOrderId())
                                        .queryParam("symbol", request.getSymbol())
                                        .queryParamIfPresent("recvWindow", Optional.ofNullable(request.getRecvWindow()))
                                        .build()
                        )
                )
                .retrieve()
                .bodyToMono(GetOrderDtoResponse.class)
                .block();
    }

    @Override
    public TransactionsResponse getListOfLedgers(TransactionsRequest request) {
        return this.client.get()
                .uri(uriBuilder ->
                        this.createUriWithSignature(
                                this.buildWithTime(uriBuilder, adapterProps.getListOfLedgers(), request.getTimestamp())
                                        .queryParamIfPresent("recvWindow", Optional.ofNullable(request.getRecvWindow()))
                                        .queryParamIfPresent("startTime", Optional.ofNullable(request.getStartTime()))
                                        .queryParamIfPresent("endTime", Optional.ofNullable(request.getEndTime()))
                                        .queryParamIfPresent("limit", Optional.ofNullable(request.getLimit()))
                                        .build()
                        )
                )
                .retrieve()
                .bodyToMono(TransactionsResponse.class)
                .block();
    }

    @Override
    public List<MyTradesResponse> getListOfTrades(AllMyTradesRequest request) {
        return this.client.get()
                .uri(uriBuilder ->
                        this.createRawUriWithSignature(
                                this.buildWithTime(this.disableEncoding(uriBuilder), adapterProps.getListOfTrades(), request.getTimestamp())
                                        .queryParam("symbol", request.getSymbol())
                                        .queryParamIfPresent("recvWindow", Optional.ofNullable(request.getRecvWindow()))
                                        .queryParamIfPresent("startTime", Optional.ofNullable(request.getStartTime()))
                                        .queryParamIfPresent("endTime", Optional.ofNullable(request.getEndTime()))
                                        .queryParamIfPresent("limit", Optional.ofNullable(request.getLimit()))
                                        .build()
                        )
                )
                .retrieve()
                .bodyToFlux(MyTradesResponse.class)
                .collectList()
                .block();
    }

    @Override
    public List<QueryOrderResponse> getListOfOpenOrders(SignedBySymbolRequest request) {
        return this.client.get()
                .uri(uriBuilder ->
                        this.createRawUriWithSignature(
                                this.buildWithTime(this.disableEncoding(uriBuilder), adapterProps.getListOfOpenOrders(), request.getTimestamp())
                                        .queryParamIfPresent("symbol", Optional.ofNullable(request.getSymbol()))
                                        .queryParamIfPresent("recvWindow", Optional.ofNullable(request.getRecvWindow()))
                                        .build()
                        )
                )
                .retrieve()
                .bodyToFlux(QueryOrderResponse.class)
                .collectList()
                .block();
    }

    @Override
    public NewOrderResponse createOrder(CreateOrderRequest request) {
        return this.client.post()
                .uri(uriBuilder ->
                        this.createRawUriWithSignature(
                                this.buildWithTime(this.disableEncoding(uriBuilder), adapterProps.getCreateOrder(), request.getTimestamp())
                                        .queryParam("quantity", request.getQuantity())
                                        .queryParam("side", request.getSide())
                                        .queryParam("symbol", request.getSymbol())
                                        .queryParam("type", request.getType())
                                        .queryParamIfPresent("accountId", Optional.ofNullable(request.getAccountId()))
                                        .queryParamIfPresent("expireTimestamp", Optional.ofNullable(request.getExpireTimestamp()))
                                        .queryParamIfPresent("guaranteedStopLoss", Optional.ofNullable(request.getGuaranteedStopLoss()))
                                        .queryParamIfPresent("leverage", Optional.ofNullable(request.getLeverage()))
                                        .queryParamIfPresent("newOrderRespType", Optional.ofNullable(request.getNewOrderRespType()))
                                        .queryParamIfPresent("price", Optional.ofNullable(request.getPrice()))
                                        .queryParamIfPresent("recvWindow", Optional.ofNullable(request.getRecvWindow()))
                                        .queryParamIfPresent("stopLoss", Optional.ofNullable(request.getStopLoss()))
                                        .queryParamIfPresent("takeProfit", Optional.ofNullable(request.getTakeProfit()))
                                        .build()
                        )
                )
                .retrieve()
                .bodyToMono(NewOrderResponse.class)
                .block();
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrderRequest request) {
        return this.client.delete()
                .uri(uriBuilder ->
                        this.createRawUriWithSignature(
                                this.buildWithTime(this.disableEncoding(uriBuilder), adapterProps.getCreateOrder(), request.getTimestamp())
                                        .queryParam("orderId", request.getOrderId())
                                        .queryParam("symbol", request.getSymbol())
                                        .queryParamIfPresent("recvWindow", Optional.ofNullable(request.getRecvWindow()))
                                        .build()
                        )
                )
                .retrieve()
                .bodyToMono(CancelOrderResponse.class)
                .block();
    }

    @Override
    public TradingPositionHistoryResponse getListOfHistoricalPositions(PositionHistoryRequest request) {
        return this.client.get()
                .uri(uriBuilder ->
                        this.createRawUriWithSignature(
                                this.buildWithTime(this.disableEncoding(uriBuilder),
                                                adapterProps.getListOfHistoricalPositions(), request.getTimestamp())
                                        .queryParamIfPresent("symbol", Optional.ofNullable(request.getSymbol()))
                                        .queryParamIfPresent("recvWindow", Optional.ofNullable(request.getRecvWindow()))
                                        .queryParamIfPresent("limit", Optional.ofNullable(request.getLimit()))
                                        .build()
                        )
                )
                .retrieve()
                .bodyToMono(TradingPositionHistoryResponse.class)
                .block();
    }

    @Override
    public TransactionsResponse getListOfTransactions(TransactionsRequest request) {
        return this.client.get()
                .uri(uriBuilder ->
                        this.createUriWithSignature(
                                this.buildWithTime(uriBuilder, adapterProps.getListOfTransactions(), request.getTimestamp())
                                        .queryParamIfPresent("recvWindow", Optional.ofNullable(request.getRecvWindow()))
                                        .queryParamIfPresent("startTime", Optional.ofNullable(request.getStartTime()))
                                        .queryParamIfPresent("endTime", Optional.ofNullable(request.getEndTime()))
                                        .queryParamIfPresent("limit", Optional.ofNullable(request.getLimit()))
                                        .build()
                        )
                )
                .retrieve()
                .bodyToMono(TransactionsResponse.class)
                .block();
    }
}
