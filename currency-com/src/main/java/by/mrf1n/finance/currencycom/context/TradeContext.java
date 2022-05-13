package by.mrf1n.finance.currencycom.context;

import by.mrf1n.finance.currencycom.model.AggTradesRequest;
import by.mrf1n.finance.currencycom.model.AggTradesResponse;
import by.mrf1n.finance.currencycom.model.DepthRequest;
import by.mrf1n.finance.currencycom.model.DepthResponse;
import by.mrf1n.finance.currencycom.model.GetOrderDtoResponse;
import by.mrf1n.finance.currencycom.model.GetOrderRequest;

public interface TradeContext {

  AggTradesResponse getAggTrades(AggTradesRequest request);

  DepthResponse getOrderBook(DepthRequest request);

  GetOrderDtoResponse getOrder(GetOrderRequest request);
}
