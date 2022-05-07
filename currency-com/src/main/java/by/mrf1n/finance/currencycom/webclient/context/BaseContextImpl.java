package by.mrf1n.finance.currencycom.webclient.context;


import by.mrf1n.finance.currencycom.property.CurrencyComAdapterProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

public abstract class BaseContextImpl {

  protected String authKey;
  protected String authSecret;
  protected WebClient client;
  protected ObjectMapper mapper;

  protected CurrencyComAdapterProperties adapterProperties;

  public BaseContextImpl(String authKey, String authSecret, WebClient client) {
    this.authKey = authKey;
    this.authSecret = authSecret;
    this.client = client;
    this.mapper = new ObjectMapper();
  }

  @Autowired
  public void setCurrencyComAdapterProperties(CurrencyComAdapterProperties adapterProperties) {
    this.adapterProperties = adapterProperties;
  }
}
