package by.mrf1n.finance.bank.nbrbby.model.rate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@SuperBuilder(toBuilder = true)
public abstract class RateRequest {
    private final Date onDate;

    public String getDateByNbRbFormat() {
        return onDate != null
                ? new SimpleDateFormat("yyyy-MM-dd").format(onDate)
                : null;
    }
}
