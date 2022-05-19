package by.mrf1n.finance.currencycom;

import by.mrf1n.finance.currencycom.context.AccountContext;
import by.mrf1n.finance.currencycom.context.EnvironmentContext;
import by.mrf1n.finance.currencycom.context.MarketCapContext;
import by.mrf1n.finance.currencycom.context.MarketContext;
import by.mrf1n.finance.currencycom.context.TradeContext;
import by.mrf1n.finance.currencycom.context.TradeLeverageContext;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Closeable;

@ToString
@EqualsAndHashCode
public abstract class CurrencyComOpenApi implements Closeable {

  protected AccountContext accountContext;
  protected EnvironmentContext environmentContext;
  protected MarketContext marketContext;
  protected TradeContext tradeContext;
  protected TradeLeverageContext leverageContext;

  protected MarketCapContext marketCryptoContext;
  protected MarketCapContext marketTokenContext;
  protected MarketCapContext marketTokenCryptoContext;

  public AccountContext getAccountContext() {
    return accountContext;
  }

  public EnvironmentContext getEnvironmentContext() {
    return this.environmentContext;
  }

  public MarketContext getMarketContext() {
    return this.marketContext;
  }

  public TradeContext getTradeContext() {
    return tradeContext;
  }

  public TradeLeverageContext getLeverageContext() {
    return leverageContext;
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

  public abstract void setAccountContext(AccountContext accountContext);

  public abstract void setEnvironmentContext(EnvironmentContext environmentContext);

  public abstract void setMarketContext(MarketContext marketContext);

  public abstract void setTradeContext(TradeContext tradeContext);

  public abstract void setLeverageContext(TradeLeverageContext leverageContext);

  public abstract void setMarketCryptoContext(MarketCapContext marketCryptoContext);

  public abstract void setMarketTokenContext(MarketCapContext marketTokenContext);

  public abstract void setMarketTokenCryptoContext(MarketCapContext marketTokenCryptoContext);
}
