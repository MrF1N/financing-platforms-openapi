package by.mrf1n.finance.currencycom.model;

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
public class AccountResponse implements Serializable {

  private String affiliateId;
  private List<AccountBalance> balances;
  private Double buyerCommission;
  private Boolean canDeposit;
  private Boolean canTrade;
  private Boolean canWithdraw;
  private Double makerCommission;
  private Double sellerCommission;
  private Double takerCommission;
  private BigInteger updateTime;
  private BigInteger userId;
}
