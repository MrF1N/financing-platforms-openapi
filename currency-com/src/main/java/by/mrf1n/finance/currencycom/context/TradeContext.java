package by.mrf1n.finance.currencycom.context;

import by.mrf1n.finance.currencycom.model.AggTradesRequest;
import by.mrf1n.finance.currencycom.model.AggTradesResponse;
import by.mrf1n.finance.currencycom.model.DepthRequest;
import by.mrf1n.finance.currencycom.model.DepthResponse;

public interface TradeContext {

  AggTradesResponse getAggTrades(AggTradesRequest request);

  DepthResponse getOrderBook(DepthRequest request);
}
