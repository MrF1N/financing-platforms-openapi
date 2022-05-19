package by.mrf1n.finance.bank.alfabankby.model;

import by.mrf1n.finance.bank.alfabankby.model.enums.CountryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class BankListRequest implements Serializable {

    private CountryType type;
    private String search;
    private Integer pageNo;
    private Integer pageRowCount;
}
