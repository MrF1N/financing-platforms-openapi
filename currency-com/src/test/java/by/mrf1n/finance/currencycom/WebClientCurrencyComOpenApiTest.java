package by.mrf1n.finance.currencycom;

import by.mrf1n.finance.currencycom.model.AccountRequest;
import by.mrf1n.finance.currencycom.model.AccountResponse;
import by.mrf1n.finance.currencycom.model.ExchangeInfo;
import by.mrf1n.finance.currencycom.model.KLinesRequest;
import by.mrf1n.finance.currencycom.model.KLinesResponse;
import by.mrf1n.finance.currencycom.model.enums.Interval;
import by.mrf1n.finance.currencycom.webclient.WebClientCurrencyComOpenApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@ContextConfiguration(classes = {CurrencyComOpenApiTestConfig.class})
@SpringBootTest
public class WebClientCurrencyComOpenApiTest {

  private WebClientCurrencyComOpenApi webClientCurrencyComOpenApi;

  @Test
  public void getExchangeInfoTest() {
    ExchangeInfo exchangeInfo = webClientCurrencyComOpenApi.getMarketContext().getExchangeInfo();
    System.out.println(exchangeInfo);
  }

  @Test
  public void getKlinesTest() {
    KLinesRequest request = KLinesRequest.builder()
        .interval(Interval.M1)
        .symbol("LTC/BTC")
        .build();
    List<List<Number>> klines = webClientCurrencyComOpenApi.getMarketContext().getKlines(request);
    System.out.println(klines);
  }

  @Test
  public void getAccountInfo() {
    AccountRequest request = AccountRequest.builder()
            .recvWindow(BigInteger.valueOf(60000))
            .showZeroBalance(true)
            .timestamp(BigInteger.valueOf(new Date().getTime()))
            .build();
    AccountResponse accountInfo = webClientCurrencyComOpenApi.getAccountContext().getAccountInfo(request);
    System.out.println(accountInfo);
  }

  @Autowired
  public void setWebClientCurrencyComOpenApi(WebClientCurrencyComOpenApi webClientCurrencyComOpenApi) {
    this.webClientCurrencyComOpenApi = webClientCurrencyComOpenApi;
  }
}
