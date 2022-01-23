package by.mrf1n.finance.currencycom.context;

import by.mrf1n.finance.currencycom.model.CloseTradingPositionRequest;
import by.mrf1n.finance.currencycom.model.TradingPositionCloseAllResponse;

public interface TradeLeverageContext {

  public TradingPositionCloseAllResponse closeTradingPosition(CloseTradingPositionRequest request);
}
