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
public class ExchangeInfo implements Serializable {

  private List<ExchangeFilter> exchangeFilters;
  private List<RateLimits> rateLimits;
  private BigInteger serverTime;
  private List<ExchangeSymbolInfo> symbols;
  private String timezone;

}
