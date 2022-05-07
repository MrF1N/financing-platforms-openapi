package by.mrf1n.finance.currencycom.webclient.context;

import by.mrf1n.finance.currencycom.context.MarketContext;
import by.mrf1n.finance.currencycom.model.ExchangeInfo;
import by.mrf1n.finance.currencycom.model.KLinesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Component
public class MarketContextImpl extends BaseContextImpl implements MarketContext {

  @Autowired
  public MarketContextImpl(String authKey, String authSecret, WebClient adapterWebClient) {
    super(authKey, authSecret, adapterWebClient);
  }

  @Override
  public ExchangeInfo getExchangeInfo() {
    return this.client.get().uri(adapterProperties.getExchangeInfo())
        .retrieve()
        .bodyToMono(ExchangeInfo.class).block();
  }

  @Override
  public List<List<Number>> getKlines(KLinesRequest request) {
    return this.client.get()
        .uri(uriBuilder -> uriBuilder.path(adapterProperties.getKlines())
            .queryParamIfPresent("symbol", Optional.ofNullable(request.getSymbol()))
            .queryParamIfPresent("interval", Optional.ofNullable(request.getInterval()))
            .build()
        )
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<List<List<Number>>>() {}).block();
  }
}
