package by.mrf1n.finance.currencycom.model;

import by.mrf1n.finance.currencycom.model.enums.ExecutionType;
import by.mrf1n.finance.currencycom.model.enums.PositionState;
import by.mrf1n.finance.currencycom.model.enums.PositionStatus;
import by.mrf1n.finance.currencycom.model.enums.PositionType;
import by.mrf1n.finance.currencycom.model.enums.RejectReason;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class PositionExecutionReportDto implements Serializable {

    private String accountCurrency;
    private String accountId;
    private BigInteger createdTimestamp;
    private String currency;
    private BigInteger execTimestamp;
    private ExecutionType executionType;
    private Double fee;
    private List<Double> feeDetails;
    private Double fxRate;
    private Boolean gSL;
    private BigInteger instrumentId;
    private String positionId;
    private Double price;
    private Double quantity;
    private RejectReason rejectReason;
    private Double rpl;
    private Double rplConverted;
    private PositionSource source;
    private PositionStatus status;
    private Double stopLoss;
    private Double swap;
    private Double swapConverted;
    private String symbol;
    private Double takeProfit;
}
