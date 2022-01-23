package by.mrf1n.finance.currencycom;

import by.mrf1n.finance.currencycom.common.YamlPropertySourceFactory;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Configuration
@PropertySource(value = "classpath:currencycom.yml", factory = YamlPropertySourceFactory.class)
public class CurrencyComPathProperties {

  @Value("${paths.accountInfo}")
  private String accountInfo;
  @Value("${paths.tradesAggregated}")
  private String tradesAggregated;
  @Value("${paths.tradingPositionClose}")
  private String tradingPositionClose;
  @Value("${paths.orderBook}")
  private String orderBook;
  @Value("${paths.klines}")
  private String klines;
  @Value("${paths.exchangeInfo}")
  private String exchangeInfo;
  @Value("${paths.leverageSettings}")
  private String leverageSettings;
  @Value("${paths.listOfTrades}")
  private String listOfTrades;
  @Value("${paths.listOfOpenOrders}")
  private String listOfOpenOrders;
  @Value("${paths.createOrder}")
  private String createOrder;
  @Value("${paths.cancelOrder}")
  private String cancelOrder;
  @Value("${paths.priceChange}")
  private String priceChange;
  @Value("${paths.serverTime}")
  private String serverTime;
  @Value("${paths.listOfLeverageTrades}")
  private String listOfLeverageTrades;
  @Value("${paths.listOfHistoricalPositions}")
  private String listOfHistoricalPositions;
  @Value("${paths.leverageOrdersEdit}")
  private String leverageOrdersEdit;
  @Value("${paths.leverageTradeEdit}")
  private String leverageTradeEdit;
}
