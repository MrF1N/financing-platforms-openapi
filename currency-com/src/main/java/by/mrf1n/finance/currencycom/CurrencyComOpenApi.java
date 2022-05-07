package by.mrf1n.finance.currencycom;

import by.mrf1n.finance.currencycom.context.EnvironmentContext;
import by.mrf1n.finance.currencycom.context.MarketCapContext;
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
  protected MarketCapContext marketCryptoContext;
  protected MarketCapContext marketTokenContext;
  protected MarketCapContext marketTokenCryptoContext;

  public EnvironmentContext getEnvironmentContext() {
    return this.environmentContext;
  }

  public MarketContext getMarketContext() {
    return this.marketContext;
  }

  public MarketCapContext getMarketCryptoContext() {
    return this.marketCryptoContext;
  }

  public MarketCapContext getMarketTokenContext() {
    return this.marketTokenContext;
  }

  public MarketCapContext getMarketTokenCryptoContext() {
    return this.marketTokenCryptoContext;
  }

  public abstract void setEnvironmentContext(EnvironmentContext environmentContext);

  public abstract void setMarketContext(MarketContext marketContext);

  public abstract void setMarketCryptoContext(MarketCapContext marketCryptoContext);

  public abstract void setMarketTokenContext(MarketCapContext marketTokenContext);

  public abstract void setMarketTokenCryptoContext(MarketCapContext marketTokenCryptoContext);
}
