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
public class AccountRequest implements Serializable {

  private String apiKey;
  private BigInteger recvWindow;
  private Boolean showZeroBalance;
  private String signature;
  private BigInteger timestamp;
}
