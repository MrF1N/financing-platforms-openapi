package by.mrf1n.finance.currencycom.context;

import by.mrf1n.finance.currencycom.model.ExchangeInfo;
import by.mrf1n.finance.currencycom.model.KLinesRequest;
import by.mrf1n.finance.currencycom.model.KLinesResponse;

import java.util.List;

public interface MarketContext {

  public ExchangeInfo getExchangeInfo();

  public List<List<Number>> getKlines(KLinesRequest request);
}
