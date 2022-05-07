package by.mrf1n.finance.currencycom.property;

import by.mrf1n.finance.currencycom.common.YamlPropertySourceFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@ToString
@Configuration
@PropertySource(value = "classpath:currencycom.yml", factory = YamlPropertySourceFactory.class)
public class CurrencyComApiUrlProperties {

  @Value("${api.adapterApiUrl}")
  private String adapterApiUrl;
  @Value("${api.demoAdapterApiUrl}")
  private String demoAdapterApiUrl;
  @Value("${api.marketCryptoApiUrl}")
  private String marketCryptoApiUrl;
  @Value("${api.marketTokenCryptoApiUrl}")
  private String marketTokenCryptoApiUrl;
  @Value("${api.marketTokenApiUrl}")
  private String marketTokenApiUrl;
}
