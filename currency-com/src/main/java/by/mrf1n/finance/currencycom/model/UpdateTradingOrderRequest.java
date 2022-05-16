package by.mrf1n.finance.currencycom.model;

import by.mrf1n.finance.currencycom.model.enums.OrderType;
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
public class UpdateTradingOrderRequest implements Serializable {

    private String apiKey;
    private BigInteger expireTimestamp;
    private Boolean guaranteedStopLoss;
    private Double newPrice;
    private String orderId;
    private BigInteger recvWindow;
    private String signature;
    private Double stopLoss;
    private Double takeProfit;
    private BigInteger timestamp;
}
