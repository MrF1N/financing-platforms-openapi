package by.mrf1n.finance.currencycom.model;

import by.mrf1n.finance.currencycom.model.enums.OrderType;
import by.mrf1n.finance.currencycom.model.enums.PositionState;
import by.mrf1n.finance.currencycom.model.enums.PositionType;
import by.mrf1n.finance.currencycom.model.enums.TradeType;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class PositionDto implements Serializable {

    private String accountId;
    private Double closePrice;
    private Double closeQuantity;
    private BigInteger closeTimestamp;
    private Double cost;
    private BigInteger createdTimestamp;
    private String currency;
    private Double dividend;
    private Double fee;
    private Boolean guaranteedStopLoss;
    private String id;
    private BigInteger instrumentId;
    private Double margin;
    private Double openPrice;
    private Double openQuantity;
    private BigInteger openTimestamp;
    private String orderId;
    private Double rpl;
    private Double rplConverted;
    private PositionState state;
    private Double stopLoss;
    private Double swap;
    private Double swapConverted;
    private String symbol;
    private Double takeProfit;
    private PositionType type;
    private Double upl;
    private Double uplConverted;
}
