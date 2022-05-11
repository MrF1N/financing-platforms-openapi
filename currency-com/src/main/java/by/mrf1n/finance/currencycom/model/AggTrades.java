package by.mrf1n.finance.currencycom.model;

import lombok.AllArgsConstructor;
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
public class AggTrades implements Serializable {

  //Timestamp
  private BigInteger T;
  //Aggregate tradeId
  private BigInteger a;
  //Was the buyer the maker
  private Boolean m;
  //Price
  private String p;
  //Quantity (should be ignored)
  private String q;
}
