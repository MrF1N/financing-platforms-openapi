package by.mrf1n.finance.currencycom.context;

import by.mrf1n.finance.currencycom.model.AggTradesRequest;
import by.mrf1n.finance.currencycom.model.AggTradesResponse;
import by.mrf1n.finance.currencycom.model.DepthRequest;
import by.mrf1n.finance.currencycom.model.DepthResponse;

public interface TradeContext {

  public AggTradesResponse getAggTrades(AggTradesRequest request);

  public DepthResponse getOrderBook(DepthRequest request);
}
