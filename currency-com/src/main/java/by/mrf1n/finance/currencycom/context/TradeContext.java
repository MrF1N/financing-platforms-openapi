package by.mrf1n.finance.currencycom.context;

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
import by.mrf1n.finance.currencycom.model.PositionExecutionReportDto;
import by.mrf1n.finance.currencycom.model.PositionHistoryRequest;
import by.mrf1n.finance.currencycom.model.QueryOrderResponse;
import by.mrf1n.finance.currencycom.model.SignedBySymbolRequest;
import by.mrf1n.finance.currencycom.model.TradingPositionHistoryResponse;
import by.mrf1n.finance.currencycom.model.TransactionsRequest;
import by.mrf1n.finance.currencycom.model.TransactionsResponse;

import java.util.List;

public interface TradeContext {

  AggTradesResponse getAggTrades(AggTradesRequest request);

  DepthResponse getOrderBook(DepthRequest request);

  GetOrderDtoResponse getOrder(GetOrderRequest request);

  TransactionsResponse getListOfLedgers(TransactionsRequest request);

  List<MyTradesResponse> getListOfTrades(AllMyTradesRequest request);

  List<QueryOrderResponse> getListOfOpenOrders(SignedBySymbolRequest request);

  NewOrderResponse createOrder(CreateOrderRequest request);

  CancelOrderResponse cancelOrder(CancelOrderRequest request);

  TradingPositionHistoryResponse getListOfHistoricalPositions(PositionHistoryRequest request);
}
