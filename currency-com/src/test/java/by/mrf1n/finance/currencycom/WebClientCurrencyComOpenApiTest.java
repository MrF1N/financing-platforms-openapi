package by.mrf1n.finance.currencycom;

import by.mrf1n.finance.currencycom.context.AccountContext;
import by.mrf1n.finance.currencycom.context.EnvironmentContext;
import by.mrf1n.finance.currencycom.context.MarketContext;
import by.mrf1n.finance.currencycom.context.TradeContext;
import by.mrf1n.finance.currencycom.context.TradeLeverageContext;
import by.mrf1n.finance.currencycom.model.AccountRequest;
import by.mrf1n.finance.currencycom.model.AccountResponse;
import by.mrf1n.finance.currencycom.model.AggTradesRequest;
import by.mrf1n.finance.currencycom.model.AggTradesResponse;
import by.mrf1n.finance.currencycom.model.AllMyTradesRequest;
import by.mrf1n.finance.currencycom.model.BlockchainAddressGetResponse;
import by.mrf1n.finance.currencycom.model.BlockchainAddressRequest;
import by.mrf1n.finance.currencycom.model.CloseTradingPositionRequest;
import by.mrf1n.finance.currencycom.model.CreateOrderRequest;
import by.mrf1n.finance.currencycom.model.CurrencyResponse;
import by.mrf1n.finance.currencycom.model.DepthRequest;
import by.mrf1n.finance.currencycom.model.DepthResponse;
import by.mrf1n.finance.currencycom.model.ExchangeInfo;
import by.mrf1n.finance.currencycom.model.FundingLimitsDtoResponse;
import by.mrf1n.finance.currencycom.model.GetOrderDtoResponse;
import by.mrf1n.finance.currencycom.model.GetOrderRequest;
import by.mrf1n.finance.currencycom.model.KLinesRequest;
import by.mrf1n.finance.currencycom.model.LeverageSettingsRequest;
import by.mrf1n.finance.currencycom.model.LeverageSettingsResponse;
import by.mrf1n.finance.currencycom.model.MyTradesResponse;
import by.mrf1n.finance.currencycom.model.NewOrderResponse;
import by.mrf1n.finance.currencycom.model.QueryOrderResponse;
import by.mrf1n.finance.currencycom.model.SignedBySymbolRequest;
import by.mrf1n.finance.currencycom.model.TradingPositionCloseAllResponse;
import by.mrf1n.finance.currencycom.model.TransactionsRequest;
import by.mrf1n.finance.currencycom.model.TransactionsResponse;
import by.mrf1n.finance.currencycom.model.enums.Interval;
import by.mrf1n.finance.currencycom.model.enums.OrderType;
import by.mrf1n.finance.currencycom.model.enums.TradeType;
import by.mrf1n.finance.currencycom.webclient.WebClientCurrencyComOpenApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@ContextConfiguration(classes = {CurrencyComOpenApiTestConfig.class})
@SpringBootTest
public class WebClientCurrencyComOpenApiTest {

    private AccountContext accountContext;
    private EnvironmentContext environmentContext;
    private MarketContext marketContext;
    private TradeContext tradeContext;
    private TradeLeverageContext leverageContext;
    private CurrencyComOpenApiConfig config;

    @Test
    public void getAccountInfoTest() {
        AccountRequest request = AccountRequest.builder()
                .recvWindow(BigInteger.valueOf(60000))
                .showZeroBalance(true)
                .timestamp(BigInteger.valueOf(new Date().getTime()))
                .build();
        AccountResponse accountInfo = accountContext.getAccountInfo(request);
        System.out.println(accountInfo);
    }

    @Test
    public void getTradesAggregatedTest() {
        AggTradesRequest request = AggTradesRequest.builder()
                .symbol("LTC/BTC")
                .startTime(null)
                .endTime(null)
                .limit(null)
                .build();
        AggTradesResponse aggTrades = tradeContext.getAggTrades(request);
        System.out.println(aggTrades);
        Assert.notNull(aggTrades, "AggTradesResponse should be not null");
    }

    @Test
    public void closeTradingPositionTest() {
        CloseTradingPositionRequest request = CloseTradingPositionRequest.builder()
                .positionId(null)
                .build();
        TradingPositionCloseAllResponse tradingPositionCloseAllResponse = leverageContext.closeTradingPosition(request);
        System.out.println(tradingPositionCloseAllResponse);
        Assert.notNull(tradingPositionCloseAllResponse, "TradingPositionCloseAllResponse should be filled");
    }

    @Test
    public void getListOfCurrenciesTest(){
        CurrencyResponse listOfCurrencies = marketContext.getListOfCurrencies();
        System.out.println(listOfCurrencies);
        Assert.notNull(listOfCurrencies, "CurrencyResponse should be filled");
    }

    @Test
    public void getStringOfAddressTest() {
        BlockchainAddressRequest request = BlockchainAddressRequest.builder()
                .coin("BTC")
                .recvWindow(null)
                .timestamp(null)
                .build();
        BlockchainAddressGetResponse depositAddress = marketContext.getDepositAddress(request);
        System.out.println(depositAddress);
        Assert.notNull(depositAddress, "BlockchainAddressGetResponse shouldn't be null");
    }

    @Test
    public void getListOfDepositsTest() {
        TransactionsRequest request = TransactionsRequest.builder()
                .startTime(null)
                .endTime(null)
                .limit(100)
                .recvWindow(BigInteger.valueOf(5000L))
                .build();
        TransactionsResponse response = accountContext.getListOfDeposits(request);
        System.out.println(response);
        Assert.notNull(response, "TransactionsResponse shouldn't be null");
    }

    @Test
    public void getOrderBookTest() {
        DepthRequest request = DepthRequest.builder()
                .limit(1000)
                .symbol("BTC/USD")
                .build();
        DepthResponse response = tradeContext.getOrderBook(request);
        System.out.println(response);
        Assert.notNull(response, "DepthResponse shouldn't be null");
    }

    @Test
    public void getExchangeInfoTest() {
        ExchangeInfo exchangeInfo = marketContext.getExchangeInfo();
        System.out.println(exchangeInfo);
        Assert.notNull(exchangeInfo, "ExchangeInfo shouldn't be null");
    }

    @Test
    public void getOrderTest() {
        GetOrderRequest request = GetOrderRequest.builder()
                .orderId("00000000-0000-0002-0000-000006205692")
                .recvWindow(BigInteger.valueOf(60000))
                .symbol("DOGE%2FUSD")
                .build();
        GetOrderDtoResponse order = tradeContext.getOrder(request);
        System.out.println(order);
        Assert.notNull(order, "GetOrderDtoResponse shouldn't be null");
    }


    @Test
    public void getFundingLimitsTest() {
        List<FundingLimitsDtoResponse> response = accountContext.getFundingLimits();
        System.out.println(response);
        Assert.notNull(response, "List<FundingLimitsDtoResponse> shouldn't be empty");
    }


    @Test
    public void getKlinesTest() {
        KLinesRequest request = KLinesRequest.builder()
                .interval(Interval.M1)
                .symbol("LTC/EUR")
                .build();
        List<List<Number>> klines = marketContext.getKlines(request);
        System.out.println(klines);
    }

    @Test
    public void getListOfLedgersTest() {
        TransactionsRequest request = TransactionsRequest.builder()
                .startTime(null)
                .endTime(null)
                .limit(100)
                .recvWindow(BigInteger.valueOf(5000L))
                .build();
        TransactionsResponse response = tradeContext.getListOfLedgers(request);
        System.out.println(response);
        Assert.notNull(response, "TransactionsResponse shouldn't be null");
    }

     @Test
     public void getLeverageSettingsTest() {
         LeverageSettingsRequest request = LeverageSettingsRequest.builder()
                 .recvWindow(BigInteger.valueOf(10000))
                 .symbol("BTC%2FUSD_LEVERAGE")
                 .build();
         LeverageSettingsResponse leverageSettings = leverageContext.getLeverageSettings(request);
         System.out.println(leverageSettings);
         Assert.notNull(leverageSettings, "LeverageSettingsResponse shouldn't be null");
     }

     @Test
     public void getListOfTradesTest() {
         AllMyTradesRequest request = AllMyTradesRequest.builder()
                 .symbol("BTC%2FUSD")
                 .recvWindow(BigInteger.valueOf(10000))
                 .startTime(null)
                 .endTime(null)
                 .limit(null)
                 .build();
         List<MyTradesResponse> response = tradeContext.getListOfTrades(request);
         System.out.println(response);
         Assert.notNull(response, "List<MyTradesResponse> shouldn't be empty");
     }

     @Test
     public void getListOfOpenOrdersTest() {
         SignedBySymbolRequest request = SignedBySymbolRequest.builder()
                 .recvWindow(BigInteger.valueOf(10000))
                 .symbol(null)
                 .build();
         List<QueryOrderResponse> response = tradeContext.getListOfOpenOrders(request);
         System.out.println(response);
         Assert.notNull(response, "List<QueryOrderResponse> shouldn't be empty");
     }

     @Test
     public void createOrderTest() {
         CreateOrderRequest request = CreateOrderRequest.builder()
                 .quantity(0.01)
                 .side(TradeType.SELL)
                 .symbol("LTC%2FUSD")
                 .type(OrderType.LIMIT)
                 .price("100")
                 .build();
         NewOrderResponse order = tradeContext.createOrder(request);
         System.out.println(order);
         Assert.notNull(order, "NewOrderResponse shouldn't be null");
     }

    @Autowired
    public void setWebClientCurrencyComOpenApi(WebClientCurrencyComOpenApi webClientCurrencyComOpenApi) {
        this.accountContext = webClientCurrencyComOpenApi.getAccountContext();
        this.environmentContext = webClientCurrencyComOpenApi.getEnvironmentContext();
        this.marketContext = webClientCurrencyComOpenApi.getMarketContext();
        this.tradeContext = webClientCurrencyComOpenApi.getTradeContext();
        this.leverageContext = webClientCurrencyComOpenApi.getLeverageContext();

    }

    @Autowired
    public void setCurrencyComOpenApiConfig(CurrencyComOpenApiConfig currencyComOpenApiConfig) {
        this.config = currencyComOpenApiConfig;
    }
}
