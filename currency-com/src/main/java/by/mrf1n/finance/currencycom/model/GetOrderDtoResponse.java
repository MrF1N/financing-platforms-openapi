package by.mrf1n.finance.currencycom.model;

import by.mrf1n.finance.currencycom.model.enums.LeveragingType;
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
public class GetOrderDtoResponse implements Serializable {

    private String accountId;
    private Double execPrice;
    private Double execQuantity;
    private BigInteger expireTime;
    private Boolean guaranteedStopLoss;
    private Double margin;
    private String orderId;
    private Double price;
    private Double quantity;
    private String side;
    private String status;
    private Double stopLoss;
    private LeveragingType stopLossType;
    private Double takeProfit;
    private LeveragingType takeProfitType;
    private String timeInForceType;
    private BigInteger timestamp;
    private String type;
}
