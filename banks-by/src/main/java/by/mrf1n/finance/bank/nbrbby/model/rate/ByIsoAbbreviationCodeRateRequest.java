package by.mrf1n.finance.bank.nbrbby.model.rate;

import by.mrf1n.finance.bank.nbrbby.model.enums.CurrencyIdMode;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ByIsoAbbreviationCodeRateRequest extends ByCodeRateRequest {

    @Override
    public CurrencyIdMode getParamMode() {
        return CurrencyIdMode.ISO_CODE;
    }
}
