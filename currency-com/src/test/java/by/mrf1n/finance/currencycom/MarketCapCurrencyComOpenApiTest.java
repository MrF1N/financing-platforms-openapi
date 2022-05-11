package by.mrf1n.finance.currencycom;

import by.mrf1n.finance.currencycom.context.MarketCapContext;
import by.mrf1n.finance.currencycom.model.AssetsEntry;
import by.mrf1n.finance.currencycom.model.CompletedTrade;
import by.mrf1n.finance.currencycom.model.DepthOrderBookResponse;
import by.mrf1n.finance.currencycom.model.OHLCResponse;
import by.mrf1n.finance.currencycom.model.SummaryDto;
import by.mrf1n.finance.currencycom.model.TickerDto;
import by.mrf1n.finance.currencycom.model.enums.Depth;
import by.mrf1n.finance.currencycom.model.enums.Interval;
import by.mrf1n.finance.currencycom.model.enums.TradeType;
import by.mrf1n.finance.currencycom.webclient.WebClientCurrencyComOpenApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import javax.naming.OperationNotSupportedException;
import java.util.List;

@ContextConfiguration(classes = {CurrencyComOpenApiTestConfig.class})
@SpringBootTest
public class MarketCapCurrencyComOpenApiTest {

    private MarketCapContext marketCryptoContext;
    private MarketCapContext marketTokenContext;
    private MarketCapContext marketTokenCryptoContext;

    @Test
    public void getListOfAssetsCryptoTest() {
        List<AssetsEntry> listOfAssets = marketTokenContext.getListOfAssets();
        System.out.println(listOfAssets);
        Assert.notEmpty(listOfAssets, "ListOfAssets is empty");
    }

    @Test
    public void getOrderBookDepthCryptoTest() {
        DepthOrderBookResponse orderBookDepth = marketCryptoContext
                .getOrderBookDepth("LTC/BTC", Depth.ZERO, 1);
        System.out.println(orderBookDepth);
        Assert.notNull(orderBookDepth, "DepthOrderBookResponse is null");
    }

    @Test
    public void getMarketDataCryptoTest() {
        SummaryDto summaryDto = marketCryptoContext.getMarketData();
        System.out.println(summaryDto);
        Assert.notNull(summaryDto, "SummaryDto is null");
    }

    @Test
    public void getPriceChangeCryptoTest() {
        List<TickerDto> priceChange = marketCryptoContext.getPriceChange();
        System.out.println(priceChange);
        Assert.notEmpty(priceChange, "TickerDto is null");
    }

    @Test
    public void getListOfTradesCryptoTest() {
        List<CompletedTrade> completedTrades = marketCryptoContext.getListOfTrades("UNI/USD", TradeType.SELL);
        System.out.println(completedTrades);
        Assert.notEmpty(completedTrades, "List of CompletedTrade is empty");
    }

    @Test
    public void getCandlesDataCcryptoTest() throws OperationNotSupportedException {
        List<List<Number>> candlesData = marketCryptoContext.getCandlesData("UNI/USD", Interval.M1, null, null, null);
        System.out.println(candlesData);
        Assert.notEmpty(candlesData, "List of CandlesData is empty");
    }

    @Test
    public void getOHLCTokenCryptoTest() throws OperationNotSupportedException {
        OHLCResponse ohlc = marketTokenCryptoContext.getOHLC("UNI/USD", Interval.D1, null);
        System.out.println(ohlc);
        Assert.notNull(ohlc, "OHLCResponse is null");
    }

    @Autowired
    public void setWebClientCurrencyComOpenApi(WebClientCurrencyComOpenApi currencyComOpenApi) {
        this.marketCryptoContext = currencyComOpenApi.getMarketCryptoContext();
        this.marketTokenContext = currencyComOpenApi.getMarketTokenContext();
        this.marketTokenCryptoContext = currencyComOpenApi.getMarketTokenCryptoContext();
    }
}
