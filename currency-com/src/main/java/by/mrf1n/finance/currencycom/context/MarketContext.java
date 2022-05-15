package by.mrf1n.finance.currencycom.context;

import by.mrf1n.finance.currencycom.model.BlockchainAddressGetResponse;
import by.mrf1n.finance.currencycom.model.BlockchainAddressRequest;
import by.mrf1n.finance.currencycom.model.BySymbolRequest;
import by.mrf1n.finance.currencycom.model.CurrencyResponse;
import by.mrf1n.finance.currencycom.model.ExchangeInfo;
import by.mrf1n.finance.currencycom.model.KLinesRequest;
import by.mrf1n.finance.currencycom.model.Ticker24HResponse;
import by.mrf1n.finance.currencycom.model.TradingFeesResponse;
import by.mrf1n.finance.currencycom.model.TradingLimitsResponse;

import java.util.List;

public interface MarketContext {

    CurrencyResponse getListOfCurrencies();

    BlockchainAddressGetResponse getDepositAddress(BlockchainAddressRequest request);

    ExchangeInfo getExchangeInfo();

    List<List<Number>> getKlines(KLinesRequest request);

    Ticker24HResponse getPriceChange(BySymbolRequest request);

    List<TradingFeesResponse> getListOfFees(BySymbolRequest request);

    List<TradingLimitsResponse> getTradingLimits(BySymbolRequest request);
}
