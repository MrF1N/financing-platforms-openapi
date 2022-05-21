package by.mrf1n.finance.bank.nbrbby.model.rate;

import by.mrf1n.finance.bank.nbrbby.model.enums.Periodicity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ByPeriodicityRateRequest extends RateRequest {

    private final Periodicity periodicity;

}
