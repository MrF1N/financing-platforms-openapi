package by.mrf1n.finance.currencycom.context;

import by.mrf1n.finance.currencycom.model.*;
import by.mrf1n.finance.currencycom.model.enums.Depth;
import by.mrf1n.finance.currencycom.model.enums.Interval;
import by.mrf1n.finance.currencycom.model.enums.TradeTypeCap;
import org.springframework.lang.NonNull;

import javax.naming.OperationNotSupportedException;
import java.math.BigInteger;
import java.util.List;

public interface MarketCapContext {

    List<AssetsEntry> getListOfAssets();

    List<List<Number>> getCandlesData(@NonNull String symbol,
                                      @NonNull Interval interval,
                                      BigInteger startTime,
                                      BigInteger endTime, Integer limit) throws OperationNotSupportedException;

    OHLCResponse getOHLC(@NonNull String symbol, Interval interval,
                         BigInteger since) throws OperationNotSupportedException;

    DepthOrderBookResponse getOrderBookDepth(@NonNull String symbol, Depth depth, Integer level);

    SummaryDto getMarketData();

    List<TickerDto> getPriceChange();

    List<CompletedTrade> getListOfTrades(@NonNull String symbol, TradeTypeCap type);

}
