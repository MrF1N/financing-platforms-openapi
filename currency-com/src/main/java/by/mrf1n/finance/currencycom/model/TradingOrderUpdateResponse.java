package by.mrf1n.finance.currencycom.model;

import by.mrf1n.finance.currencycom.model.enums.TradingPositionState;
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
public class TradingOrderUpdateResponse implements Serializable {

    private BigInteger requestId;
    private TradingPositionState state;
}
