package by.mrf1n.finance.currencycom.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class TradingFeesResponse implements Serializable {

    private Double fee;
    private String name;
    private BigInteger overnightFeeTimestamp;
    private OvernightRate overnightRates;
    private String symbol;
}
