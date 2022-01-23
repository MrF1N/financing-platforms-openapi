package by.mrf1n.finance.currencycom.webclient;

import by.mrf1n.finance.currencycom.CurrencyComOpenApi;
import by.mrf1n.finance.currencycom.context.EnvironmentContext;
import by.mrf1n.finance.currencycom.context.MarketContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WebClientCurrencyComOpenApi extends CurrencyComOpenApi {

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

  @Override
  public void close() throws IOException {
  }
}
