package by.mrf1n.finance.currencycom.property;

import by.mrf1n.finance.currencycom.common.YamlPropertySourceFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@ToString
@Configuration
@PropertySource(value = "classpath:currencycom.yml", factory = YamlPropertySourceFactory.class)
public class CurrencyComAdapterProperties {

  @Value("${adapter-paths.accountInfo}")
  private String accountInfo;
  @Value("${adapter-paths.tradesAggregated}")
  private String tradesAggregated;
  @Value("${adapter-paths.tradingPositionClose}")
  private String tradingPositionClose;
  @Value("${adapter-paths.listOfCurrencies}")
  private String listOfCurrencies;
  @Value("${adapter-paths.stringOfAddress}")
  private String stringOfAddress;
  @Value("${adapter-paths.listOfDeposits}")
  private String listOfDeposits;
  @Value("${adapter-paths.orderBook}")
  private String orderBook;
  @Value("${adapter-paths.exchangeInfo}")
  private String exchangeInfo;
  @Value("${adapter-paths.order}")
  private String order;
  @Value("${adapter-paths.listOfFundingLimits}")
  private String listOfFundingLimits;
  @Value("${adapter-paths.klines}")
  private String klines;
  @Value("${adapter-paths.listOfLedgers}")
  private String listOfLedgers;
  @Value("${adapter-paths.leverageSettings}")
  private String leverageSettings;
  @Value("${adapter-paths.listOfTrades}")
  private String listOfTrades;
  @Value("${adapter-paths.listOfOpenOrders}")
  private String listOfOpenOrders;
  @Value("${adapter-paths.createOrder}")
  private String createOrder;
  @Value("${adapter-paths.cancelOrder}")
  private String cancelOrder;
  @Value("${adapter-paths.priceChange}")
  private String priceChange;
  @Value("${adapter-paths.serverTime}")
  private String serverTime;
  @Value("${adapter-paths.listOfFees}")
  private String listOfFees;
  @Value("${adapter-paths.listOfLimits}")
  private String listOfLimits;
  @Value("${adapter-paths.listOfLeverageTrades}")
  private String listOfLeverageTrades;
  @Value("${adapter-paths.listOfHistoricalPositions}")
  private String listOfHistoricalPositions;
  @Value("${adapter-paths.listOfTransactions}")
  private String listOfTransactions;
  @Value("${adapter-paths.leverageOrdersEdit}")
  private String leverageOrdersEdit;
  @Value("${adapter-paths.leverageTradeEdit}")
  private String leverageTradeEdit;
  @Value("${adapter-paths.listOfWithdrawals}")
  private String listOfWithdrawals;
}
