package by.mrf1n.finance.bank.nbrbby.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class DynamicOfRateRequest implements Serializable {

    private Integer currencyId;
    private Date startDate;
    private Date endDate;


    public String getStartDateByNbRbFormat() {
        return startDate != null
                ? new SimpleDateFormat("yyyy-MM-dd").format(startDate)
                : null;
    }

    public String getEndDateByNbRbFormat() {
        return endDate != null
                ? new SimpleDateFormat("yyyy-MM-dd").format(endDate)
                : null;
    }
}
