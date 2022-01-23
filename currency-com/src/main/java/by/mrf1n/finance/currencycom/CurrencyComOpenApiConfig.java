package by.mrf1n.finance.currencycom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Import({CurrencyComPathProperties.class, CurrencyComApiProperties.class})
@ComponentScan(basePackages = {"by.mrf1n.finance.currencycom.webclient"})
public class CurrencyComOpenApiConfig {

  protected CurrencyComApiProperties apiProperties;

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
    return false;
  }

  @Bean
  public String apiUrl() {
    return sandboxMode() ? apiProperties.getDemoHostApiUrl() : apiProperties.getHostApiUrl();
  }

  @Bean
  public WebClient webClient(WebClient.Builder builder) {
    return builder
        .baseUrl(this.apiUrl())
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
  public CurrencyComOpenApiConfig(CurrencyComApiProperties apiProperties) {
    this.apiProperties = apiProperties;
  }
}
