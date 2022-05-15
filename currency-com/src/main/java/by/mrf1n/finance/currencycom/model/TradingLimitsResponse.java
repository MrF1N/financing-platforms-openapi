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
public class TradingLimitsResponse implements Serializable {

    private Double lastPrice;
    private Double maxVolume;
    private Double minStep;
    private Double minVolume;
    private String name;
    private String symbol;
    private Double tickSize;
}
