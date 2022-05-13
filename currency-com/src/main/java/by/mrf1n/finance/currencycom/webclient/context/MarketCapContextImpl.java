package by.mrf1n.finance.currencycom.webclient.context;

import by.mrf1n.finance.currencycom.model.enums.TradeTypeCap;
import by.mrf1n.finance.currencycom.property.CurrencyComMarketProperties;
import by.mrf1n.finance.currencycom.context.MarketCapContext;
import by.mrf1n.finance.currencycom.model.*;
import by.mrf1n.finance.currencycom.model.enums.Depth;
import by.mrf1n.finance.currencycom.model.enums.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;

import javax.naming.OperationNotSupportedException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public abstract class MarketCapContextImpl extends BaseContextImpl implements MarketCapContext {

    protected CurrencyComMarketProperties marketProperties;

    public MarketCapContextImpl() {
        super("", "");
    }

    @Override
    public List<AssetsEntry> getListOfAssets() {
        return Objects.requireNonNull(this.client.get()
                        .uri(marketProperties.getListOfAssets())
                        .retrieve()
                        .bodyToMono(new ParameterizedTypeReference<Map<String, AssetsEntry>>() {
                        })
                        .block())
                .values()
                .stream()
                .toList();
    }

    @Override
    public List<List<Number>> getCandlesData(String symbol, Interval interval,
                                             BigInteger startTime, BigInteger endTime,
                                             Integer limit) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public OHLCResponse getOHLC(String symbol,
                                Interval interval,
                                BigInteger since) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public DepthOrderBookResponse getOrderBookDepth(String symbol, Depth depth, Integer level) {
        return this.client.get()
                .uri(builder -> builder.path(this.marketProperties.getOrderbook())
                        .queryParamIfPresent("symbol", Optional.ofNullable(symbol))
                        .queryParamIfPresent("depth", Optional.ofNullable(depth))
                        .queryParamIfPresent("level", Optional.ofNullable(level))
                        .build()
                )
                .retrieve()
                .bodyToMono(DepthOrderBookResponse.class)
                .block();
    }

    @Override
    public SummaryDto getMarketData() {
        return this.client.get()
                .uri(marketProperties.getMarketData())
                .retrieve()
                .bodyToMono(SummaryDto.class)
                .block();
    }

    @Override
    public List<TickerDto> getPriceChange() {
        return Objects.requireNonNull(this.client.get()
                        .uri(marketProperties.getPriceChange())
                        .retrieve()
                        .bodyToMono(new ParameterizedTypeReference<Map<String, TickerDto>>() {
                        })
                        .block())
                .values()
                .stream()
                .toList();
    }

    @Override
    public List<CompletedTrade> getListOfTrades(String symbol, TradeTypeCap type) {
        return this.client.get()
                .uri(builder -> builder.path(this.marketProperties.getListOfTrades())
                        .queryParamIfPresent("symbol", Optional.ofNullable(symbol))
                        .queryParamIfPresent("type", Optional.ofNullable(type))
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CompletedTrade>>() {})
                .block();
    }

    @Autowired
    public void setCurrencyComMarketProperties(CurrencyComMarketProperties marketProperties) {
        this.marketProperties = marketProperties;
    }

    @Autowired
    public void setClient(WebClient marketCryptoWebClient) {
        this.client = marketCryptoWebClient;
    }
}
