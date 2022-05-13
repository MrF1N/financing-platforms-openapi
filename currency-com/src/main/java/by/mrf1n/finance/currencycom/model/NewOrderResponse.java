package by.mrf1n.finance.currencycom.model;

import by.mrf1n.finance.currencycom.model.enums.LeveragingType;
import by.mrf1n.finance.currencycom.model.enums.OrderStatus;
import by.mrf1n.finance.currencycom.model.enums.OrderType;
import by.mrf1n.finance.currencycom.model.enums.TimeInForce;
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
public class NewOrderResponse implements Serializable {

    private String executedQty;
    private BigInteger expireTimestamp;
    private Boolean guaranteedStopLoss;
    private Double margin;
    private String orderId;
    private String origQty;
    private Double price;
    private String rejectMessage;
    private TradeType side;
    private OrderStatus status;
    private Double stopLoss;
    private String symbol;
    private Double takeProfit;
    private TimeInForce timeInForce;
    private BigInteger transactTime;
    private OrderType type;
}
