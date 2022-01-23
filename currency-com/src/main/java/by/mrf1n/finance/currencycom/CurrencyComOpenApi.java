package by.mrf1n.finance.currencycom;

import by.mrf1n.finance.currencycom.context.EnvironmentContext;
import by.mrf1n.finance.currencycom.context.MarketContext;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Closeable;

@Getter
@ToString
@EqualsAndHashCode
public abstract class CurrencyComOpenApi implements Closeable {

  protected EnvironmentContext environmentContext;
  protected MarketContext marketContext;

  public EnvironmentContext getEnvironmentContext() {
    return this.environmentContext;
  }

  public MarketContext getMarketContext() {
    return this.marketContext;
  }

  public abstract void setEnvironmentContext(EnvironmentContext environmentContext);

  public abstract void setMarketContext(MarketContext marketContext);
}
