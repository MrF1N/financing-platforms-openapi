package by.mrf1n.finance.bank.nbrbby.model.rate;

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
public class Rate implements Serializable {

    @JsonProperty("Cur_ID")
    private Integer internCurrencyId;
    @JsonProperty("Date")
    private Date date;
    @JsonProperty("Cur_Abbreviation")
    private String abbreviationCode;
    @JsonProperty("Cur_Scale")
    private Integer scale;
    @JsonProperty("Cur_Name")
    private String name;
    @JsonProperty("Cur_OfficialRate")
    private Double officialRate;
}
