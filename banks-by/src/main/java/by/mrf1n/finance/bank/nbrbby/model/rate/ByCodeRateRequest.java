package by.mrf1n.finance.bank.nbrbby.model.rate;

import by.mrf1n.finance.bank.nbrbby.model.enums.CurrencyIdMode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
public abstract class ByCodeRateRequest extends RateRequest {

    private String currencyCode;

    public abstract CurrencyIdMode getParamMode();
}
