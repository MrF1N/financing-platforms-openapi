package by.mrf1n.finance.currencycom.model;

import by.mrf1n.finance.currencycom.model.enums.OrderStatus;
import by.mrf1n.finance.currencycom.model.enums.OrderType;
import by.mrf1n.finance.currencycom.model.enums.TimeInForce;
import by.mrf1n.finance.currencycom.model.enums.TradeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class CancelOrderResponse implements Serializable {


    private String executedQty;
    private String orderId;
    private String origQty;
    private Double price;
    private TradeType side;
    private OrderStatus status;
    private String symbol;
    private TimeInForce timeInForce;
    private OrderType type;
}
