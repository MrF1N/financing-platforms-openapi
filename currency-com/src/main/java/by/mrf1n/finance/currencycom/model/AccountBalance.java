package by.mrf1n.finance.currencycom.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class AccountBalance implements Serializable {

  private String accountId;
  private String asset;
  private Boolean collateralCurrency;
  private Boolean _default;
  private Double free;
  private Double locked;

}
