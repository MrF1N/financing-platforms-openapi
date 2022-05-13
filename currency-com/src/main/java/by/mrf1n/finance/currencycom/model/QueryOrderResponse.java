package by.mrf1n.finance.currencycom.model;

import by.mrf1n.finance.currencycom.model.enums.OrderStatus;
import by.mrf1n.finance.currencycom.model.enums.OrderType;
import by.mrf1n.finance.currencycom.model.enums.TimeInForce;
import by.mrf1n.finance.currencycom.model.enums.TradeType;
import by.mrf1n.finance.currencycom.model.enums.TradeTypeCap;
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
public class QueryOrderResponse implements Serializable {

    private String accountId;
    private String executedQty;
    private BigInteger expireTimestamp;
    private Boolean guaranteedStopLoss;
    private String icebergQty;
    private Boolean leverage;
    private Double margin;
    private String orderId;
    private String origQty;
    private String price;
    private TradeType side;
    private OrderStatus status;
    private Double stopLoss;
    private String symbol;
    private Double takeProfit;
    private BigInteger time;
    private TimeInForce timeInForce;
    private OrderType type;
    private BigInteger updateTime;
    private Boolean working;
}
