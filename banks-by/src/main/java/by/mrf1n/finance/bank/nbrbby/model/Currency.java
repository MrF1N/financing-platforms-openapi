package by.mrf1n.finance.bank.nbrbby.model;

import by.mrf1n.finance.bank.nbrbby.model.enums.Periodicity;
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
public class Currency implements Serializable {

    @JsonProperty("Cur_ID")
    private Integer internCurrencyId;
    @JsonProperty("Cur_ParentID")
    private Integer parentId;
    @JsonProperty("Cur_Code")
    private Integer isoCodeNumber;
    @JsonProperty("Cur_Abbreviation")
    private String isoCodeAbbreviation;
    @JsonProperty("Cur_Name")
    private String name;
    @JsonProperty("Cur_Name_Bel")
    private String nameBel;
    @JsonProperty("Cur_Name_Eng")
    private String nameEng;
    @JsonProperty("Cur_QuotName")
    private String quoteName;
    @JsonProperty("Cur_QuotName_Bel")
    private String quoteNameBel;
    @JsonProperty("Cur_QuotName_Eng")
    private String quoteNameEng;
    @JsonProperty("Cur_NameMulti")
    private String multiName;
    @JsonProperty("Cur_Name_BelMulti")
    private String multiNameBel;
    @JsonProperty("Cur_Name_EngMulti")
    private String multiNameEng;
    @JsonProperty("Cur_Scale")
    private Integer scale;
    @JsonProperty("Cur_Periodicity")
    private Periodicity periodicity;
    @JsonProperty("Cur_DateStart")
    private Date startDate;
    @JsonProperty("Cur_DateEnd")
    private Date endDate;
}
