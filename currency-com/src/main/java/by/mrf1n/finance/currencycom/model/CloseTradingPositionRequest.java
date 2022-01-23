package by.mrf1n.finance.currencycom.model;

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
public class CloseTradingPositionRequest implements Serializable {

  private String apiKey;
  private String positionId;
  private BigInteger recvWindow;
  private String signature;
  private BigInteger timestamp;
}
