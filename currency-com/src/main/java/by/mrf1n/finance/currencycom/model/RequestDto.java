package by.mrf1n.finance.currencycom.model;

import by.mrf1n.finance.currencycom.model.enums.RejectReason;
import by.mrf1n.finance.currencycom.model.enums.RequestType;
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
public class RequestDto implements Serializable {

  private String accountId;
  private BigInteger createdTimestamp;
  private BigInteger id;
  private BigInteger instrumentId;
  private String orderId;
  private String positionId;
  private RejectReason rejectReason;
  private String rqBody;
  private RequestType rqType;
  private TradingPositionState state;

}
