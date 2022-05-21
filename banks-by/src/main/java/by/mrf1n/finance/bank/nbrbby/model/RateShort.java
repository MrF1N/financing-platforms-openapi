package by.mrf1n.finance.bank.nbrbby.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class RateShort implements Serializable {

    @JsonProperty("Cur_ID")
    private Integer currencyId;
    @JsonProperty("Date")
    private Date date;
    @JsonProperty("Cur_OfficialRate")
    private Double officialRate;
}
