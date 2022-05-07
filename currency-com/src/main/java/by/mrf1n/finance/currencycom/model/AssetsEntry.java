package by.mrf1n.finance.currencycom.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class AssetsEntry implements Serializable {

    private Boolean can_deposit;
    private Boolean can_withdraw;
    private String description;
    private Double maker_fee;
    private Double max_withdraw;
    private Double min_withdraw;
    private String name;
    private Double taker_fee;
}
