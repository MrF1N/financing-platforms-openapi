package by.mrf1n.finance.currencycom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CurrencyComOpenApiConfig.class)
public class CurrencyComOpenApiTestConfig {
  @Bean
  public String authKey() {
//    return System.getenv("authSecret");
    return "";
  }

  @Bean
  public String authSecret() {
//    return System.getenv("authSecret");
    return "";
  }

  @Bean
  public boolean sandboxMode() {
    return Boolean.parseBoolean(System.getenv("isSandBoxMode"));
  }
}
