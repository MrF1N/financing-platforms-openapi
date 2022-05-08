package by.mrf1n.finance.currencycom;

import by.mrf1n.finance.currencycom.property.CurrencyComAdapterProperties;
import by.mrf1n.finance.currencycom.property.CurrencyComApiUrlProperties;
import by.mrf1n.finance.currencycom.property.CurrencyComMarketProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Import({CurrencyComAdapterProperties.class,
        CurrencyComApiUrlProperties.class,
        CurrencyComMarketProperties.class})
@ComponentScan(basePackages = {"by.mrf1n.finance.currencycom.webclient"})
public class CurrencyComOpenApiConfig {

  protected CurrencyComApiUrlProperties apiProperties;

  @Bean
  public String authKey() {
    return "";
  }

  @Bean
  public String authSecret() {
    return "";
  }

  @Bean
  public boolean sandboxMode() {
    return true;
  }

  @Bean
  public String apiUrl() {
    return sandboxMode() ? apiProperties.getDemoAdapterApiUrl() : apiProperties.getAdapterApiUrl();
  }

  @Bean
  public WebClient adapterWebClient(WebClient.Builder builder) {
    return builder
        .baseUrl(this.apiUrl())
        .build();
  }

  @Bean
  public WebClient marketCryptoWebClient(WebClient.Builder builder) {
    return builder
            .baseUrl(this.apiProperties.getMarketCryptoApiUrl())
            .build();
  }

  @Bean
  public WebClient marketTokenCryptoWebClient(WebClient.Builder builder) {
    return builder
            .baseUrl(this.apiProperties.getMarketTokenCryptoApiUrl())
            .build();
  }

  @Bean
  public WebClient marketTokenWebClient(WebClient.Builder builder) {
    return builder
            .baseUrl(this.apiProperties.getMarketTokenApiUrl())
            .build();
  }

  @Bean
  public WebClient.Builder builder() {
    return WebClient
        .builder()
        .codecs(conf -> conf.defaultCodecs()
            .maxInMemorySize(10 * 1024 * 1024));
  }

  @Autowired
  public CurrencyComOpenApiConfig(CurrencyComApiUrlProperties apiProperties) {
    this.apiProperties = apiProperties;
  }
}
