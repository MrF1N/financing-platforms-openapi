package by.mrf1n.finance.currencycom.context;

import by.mrf1n.finance.currencycom.model.BlockchainAddressGetResponse;
import by.mrf1n.finance.currencycom.model.BlockchainAddressRequest;
import by.mrf1n.finance.currencycom.model.CurrencyResponse;
import by.mrf1n.finance.currencycom.model.ExchangeInfo;
import by.mrf1n.finance.currencycom.model.KLinesRequest;

import java.util.List;

public interface MarketContext {

    CurrencyResponse getListOfCurrencies();

    BlockchainAddressGetResponse getDepositAddress(BlockchainAddressRequest request);

    ExchangeInfo getExchangeInfo();

    List<List<Number>> getKlines(KLinesRequest request);
}
