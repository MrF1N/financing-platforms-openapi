package by.mrf1n.finance.currencycom.webclient;

import by.mrf1n.finance.currencycom.context.EnvironmentContext;
import by.mrf1n.finance.currencycom.model.ServerTime;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EnvironmentContextImpl extends BaseContextImpl implements EnvironmentContext {

  public EnvironmentContextImpl(String authKey, String authSecret, WebClient client) {
    super(authKey, authSecret, client);
  }

  @Override
  public ServerTime getServerTime() {
    return null;
  }
}
