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
import by.mrf1n.finance.currencycom.model.BlockchainAddressGetResponse;
import by.mrf1n.finance.currencycom.model.BlockchainAddressRequest;
import by.mrf1n.finance.currencycom.model.CloseTradingPositionRequest;
import by.mrf1n.finance.currencycom.model.CurrencyResponse;
import by.mrf1n.finance.currencycom.model.ExchangeInfo;
import by.mrf1n.finance.currencycom.model.KLinesRequest;
import by.mrf1n.finance.currencycom.model.TradingPositionCloseAllResponse;
import by.mrf1n.finance.currencycom.model.enums.Interval;
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
    public void getAccountInfo() {
        AccountRequest request = AccountRequest.builder()
                .recvWindow(BigInteger.valueOf(60000))
                .showZeroBalance(true)
                .timestamp(BigInteger.valueOf(new Date().getTime()))
                .build();
        AccountResponse accountInfo = accountContext.getAccountInfo(request);
        System.out.println(accountInfo);
    }

    @Test
    public void getTradesAggregated() {
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
    public void getExchangeInfoTest() {
        ExchangeInfo exchangeInfo = marketContext.getExchangeInfo();
        System.out.println(exchangeInfo);
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
