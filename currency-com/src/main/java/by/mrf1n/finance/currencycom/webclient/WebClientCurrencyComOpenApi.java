package by.mrf1n.finance.currencycom.webclient;

import by.mrf1n.finance.currencycom.CurrencyComOpenApi;
import by.mrf1n.finance.currencycom.context.AccountContext;
import by.mrf1n.finance.currencycom.context.EnvironmentContext;
import by.mrf1n.finance.currencycom.context.MarketCapContext;
import by.mrf1n.finance.currencycom.context.MarketContext;
import by.mrf1n.finance.currencycom.context.TradeContext;
import by.mrf1n.finance.currencycom.context.TradeLeverageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WebClientCurrencyComOpenApi extends CurrencyComOpenApi {

  @Autowired
  @Qualifier("accountContextImpl")
  public void setAccountContext(AccountContext accountContext) {
    this.accountContext = accountContext;
  }

  @Autowired
  @Qualifier("environmentContextImpl")
  public void setEnvironmentContext(EnvironmentContext environmentContext) {
    this.environmentContext = environmentContext;
  }

  @Autowired
  @Qualifier("marketContextImpl")
  public void setMarketContext(MarketContext marketContext) {
    this.marketContext = marketContext;
  }

  @Autowired
  @Qualifier("tradeContextImpl")
  public void setTradeContext(TradeContext tradeContext) {
    this.tradeContext = tradeContext;
  }

  @Autowired
  @Qualifier("tradeLeverageContextImpl")
  public void setLeverageContext(TradeLeverageContext leverageContext) {
    this.leverageContext = leverageContext;
  }


  @Autowired
  @Qualifier("marketCryptoContextImpl")
  public void setMarketCryptoContext(MarketCapContext marketCryptoContext) {
    this.marketCryptoContext = marketCryptoContext;
  }

  @Autowired
  @Qualifier("marketTokenContextImpl")
  public void setMarketTokenContext(MarketCapContext marketTokenContext) {
    this.marketTokenContext = marketTokenContext;
  }

  @Autowired
  @Qualifier("marketTokenCryptoContextImpl")
  public void setMarketTokenCryptoContext(MarketCapContext marketTokenCryptoContext) {
    this.marketTokenCryptoContext = marketTokenCryptoContext;
  }

  @Override
  public void close() {
  }
}
