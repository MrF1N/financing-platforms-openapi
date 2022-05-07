package by.mrf1n.finance.currencycom.model;

import by.mrf1n.finance.currencycom.model.enums.TradeType;
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
public class CompletedTrade implements Serializable {

    private BigInteger tradeID;
    private Double price;
    private Double base_volume;
    private Double quote_volume;
    private BigInteger trade_timestamp;
    private TradeType type;
}