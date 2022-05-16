package by.mrf1n.finance.currencycom.model;

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
public class UpdateTradingPositionRequest implements Serializable {

    private String apiKey;
    private Boolean guaranteedStopLoss;
    private String positionId;
    private BigInteger recvWindow;
    private String signature;
    private Double stopLoss;
    private Double takeProfit;
    private BigInteger timestamp;
}
