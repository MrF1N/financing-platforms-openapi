package by.mrf1n.finance.currencycom;

import by.mrf1n.finance.currencycom.property.CurrencyComAdapterProperties;
import by.mrf1n.finance.currencycom.property.CurrencyComApiUrlProperties;
import by.mrf1n.finance.currencycom.property.CurrencyComMarketProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {
        CurrencyComAdapterProperties.class,
        CurrencyComApiUrlProperties.class,
        CurrencyComMarketProperties.class})
@SpringBootTest
public class CurrencyComPropertiesTest {

  @Autowired
  private CurrencyComAdapterProperties pathProperties;

  @Autowired
  private CurrencyComApiUrlProperties apiProperties;

  @Autowired
  private CurrencyComMarketProperties marketProperties;

  @Test
  void testProperties() {
    Assertions.assertEquals("account", pathProperties.getAccountInfo());
    Assertions.assertEquals("aggTrades", pathProperties.getTradesAggregated());
    Assertions.assertEquals("closeTradingPosition", pathProperties.getTradingPositionClose());
    Assertions.assertEquals("depth", pathProperties.getOrderBook());
    Assertions.assertEquals("exchangeInfo", pathProperties.getExchangeInfo());
    Assertions.assertEquals("klines", pathProperties.getKlines());
    Assertions.assertEquals("leverageSettings", pathProperties.getLeverageSettings());
    Assertions.assertEquals("myTrades", pathProperties.getListOfTrades());
    Assertions.assertEquals("openOrders", pathProperties.getListOfOpenOrders());
    Assertions.assertEquals("order", pathProperties.getCreateOrder());
    Assertions.assertEquals("order", pathProperties.getCancelOrder());
    Assertions.assertEquals("ticker/24hr", pathProperties.getPriceChange());
    Assertions.assertEquals("time", pathProperties.getServerTime());
    Assertions.assertEquals("tradingPositions", pathProperties.getListOfLeverageTrades());
    Assertions.assertEquals("tradingPositionsHistory", pathProperties.getListOfHistoricalPositions());
    Assertions.assertEquals("updateTradingOrder", pathProperties.getLeverageOrdersEdit());
    Assertions.assertEquals("updateTradingPosition", pathProperties.getLeverageTradeEdit());

    Assertions.assertEquals("https://api-adapter.backend.currency.com/api/v2/",
        apiProperties.getAdapterApiUrl());
    Assertions.assertEquals("https://demo-api-adapter.backend.currency.com/api/v2/",
        apiProperties.getDemoAdapterApiUrl());
  }
}
