package by.mrf1n.finance.bank.nbrbby.context;

import by.mrf1n.finance.bank.nbrbby.model.rate.ByCodeRateRequest;
import by.mrf1n.finance.bank.nbrbby.model.rate.ByPeriodicityRateRequest;
import by.mrf1n.finance.bank.nbrbby.model.Currency;
import by.mrf1n.finance.bank.nbrbby.model.DynamicOfRateRequest;
import by.mrf1n.finance.bank.nbrbby.model.rate.Rate;
import by.mrf1n.finance.bank.nbrbby.model.RateShort;

import java.util.List;

public interface NbRbByContext {

    List<Currency> getAllCurrencies();

    Currency getCurrencyById(Integer internCurrencyId);

    List<Rate> getRatesByPeriodicity(ByPeriodicityRateRequest request);

    Rate getRateByCode(ByCodeRateRequest request);

    List<RateShort> getRateByDateRange(DynamicOfRateRequest request);
}
