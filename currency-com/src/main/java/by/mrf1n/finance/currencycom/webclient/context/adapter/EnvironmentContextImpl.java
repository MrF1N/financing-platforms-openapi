package by.mrf1n.finance.currencycom.webclient.context.adapter;

import by.mrf1n.finance.currencycom.context.EnvironmentContext;
import by.mrf1n.finance.currencycom.model.ServerTime;
import by.mrf1n.finance.currencycom.webclient.context.AdapterBaseContextImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class EnvironmentContextImpl extends AdapterBaseContextImpl implements EnvironmentContext {

  @Autowired
  public EnvironmentContextImpl(String authKey, String authSecret) {
    super(authKey, authSecret);
  }

  @Override
  public ServerTime getServerTime() {
    return null;
  }
}
