package by.mrf1n.finance.currencycom.webclient;

import by.mrf1n.finance.currencycom.context.MarketContext;
import by.mrf1n.finance.currencycom.model.ExchangeInfo;
import by.mrf1n.finance.currencycom.model.KLinesRequest;
import by.mrf1n.finance.currencycom.model.KLinesResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarketContextImpl extends BaseContextImpl implements MarketContext {

  public MarketContextImpl(String authKey, String authSecret, WebClient client) {
    super(authKey, authSecret, client);
  }

  @Override
  public ExchangeInfo getExchangeInfo() {
    return this.client.get().uri(pathProperties.getExchangeInfo())
        .retrieve()
        .bodyToMono(ExchangeInfo.class).block();
  }

  @Override
  public List<List<Number>> getKlines(KLinesRequest request) {
    return this.client.get()
        .uri(uriBuilder -> uriBuilder.path(pathProperties.getKlines())
            .queryParam("symbol", request.getSymbol())
            .queryParam("interval", request.getInterval())
            .build()
        )
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<List<List<Number>>>() {}).block();
  }
}
