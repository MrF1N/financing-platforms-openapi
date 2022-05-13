package by.mrf1n.finance.currencycom.context;

import by.mrf1n.finance.currencycom.model.CloseTradingPositionRequest;
import by.mrf1n.finance.currencycom.model.LeverageSettingsRequest;
import by.mrf1n.finance.currencycom.model.LeverageSettingsResponse;
import by.mrf1n.finance.currencycom.model.TradingPositionCloseAllResponse;

public interface TradeLeverageContext {

  TradingPositionCloseAllResponse closeTradingPosition(CloseTradingPositionRequest request);

  LeverageSettingsResponse getLeverageSettings(LeverageSettingsRequest request);
}
