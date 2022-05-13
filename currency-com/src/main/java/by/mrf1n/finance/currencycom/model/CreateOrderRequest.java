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
@Builder
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest implements Serializable {

    private String accountId;
    private String apiKey;
    private BigInteger expireTimestamp;
    private Boolean guaranteedStopLoss;
    private Boolean leverage;
    private String newOrderRespType;
    private String price;
    private Double quantity;
    private BigInteger recvWindow;
    private TradeType side;
    private String signature;
    private Double stopLoss;
    private String symbol;
    private Double takeProfit;
    private BigInteger timestamp;
    private OrderType type;
}
