package by.mrf1n.finance.currencycom;

import by.mrf1n.finance.currencycom.model.ExchangeInfo;
import by.mrf1n.finance.currencycom.model.KLinesRequest;
import by.mrf1n.finance.currencycom.model.KLinesResponse;
import by.mrf1n.finance.currencycom.model.enums.Interval;
import by.mrf1n.finance.currencycom.webclient.WebClientCurrencyComOpenApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(classes = {CurrencyComOpenApiTestConfig.class})
@SpringBootTest
public class WebClientCurrencyComOpenApiTest {

  private WebClientCurrencyComOpenApi webClientCurrencyComOpenApi;

  @Test
  void getExchangeInfoTest() {
    ExchangeInfo exchangeInfo = webClientCurrencyComOpenApi.getMarketContext().getExchangeInfo();
    System.out.println(exchangeInfo);
  }

  @Test
  void getKlinesTest() {
    KLinesRequest request = KLinesRequest.builder()
        .interval(Interval.M1)
        .symbol("LTC/BTC")
        .build();
    List<List<Number>> klines = webClientCurrencyComOpenApi.getMarketContext().getKlines(request);
    System.out.println(klines);
  }

  @Autowired
  public void setWebClientCurrencyComOpenApi(WebClientCurrencyComOpenApi webClientCurrencyComOpenApi) {
    this.webClientCurrencyComOpenApi = webClientCurrencyComOpenApi;
  }
}
