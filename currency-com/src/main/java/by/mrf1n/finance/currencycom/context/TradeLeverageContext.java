package by.mrf1n.finance.currencycom.context;

import by.mrf1n.finance.currencycom.model.CloseTradingPositionRequest;
import by.mrf1n.finance.currencycom.model.LeverageSettingsRequest;
import by.mrf1n.finance.currencycom.model.LeverageSettingsResponse;
import by.mrf1n.finance.currencycom.model.SignedRequest;
import by.mrf1n.finance.currencycom.model.TradingOrderUpdateResponse;
import by.mrf1n.finance.currencycom.model.TradingPositionCloseAllResponse;
import by.mrf1n.finance.currencycom.model.TradingPositionListResponse;
import by.mrf1n.finance.currencycom.model.TradingPositionUpdateResponse;
import by.mrf1n.finance.currencycom.model.UpdateTradingOrderRequest;
import by.mrf1n.finance.currencycom.model.UpdateTradingPositionRequest;

public interface TradeLeverageContext {

  TradingPositionCloseAllResponse closeTradingPosition(CloseTradingPositionRequest request);

  LeverageSettingsResponse getLeverageSettings(LeverageSettingsRequest request);

  TradingPositionListResponse getListOfLeverageTrades(SignedRequest request);

  TradingOrderUpdateResponse updateLeverageOrder(UpdateTradingOrderRequest request);

  TradingPositionUpdateResponse updateLeverageTrade(UpdateTradingPositionRequest request);
}
