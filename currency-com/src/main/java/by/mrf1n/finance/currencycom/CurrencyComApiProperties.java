package by.mrf1n.finance.currencycom;

import by.mrf1n.finance.currencycom.common.YamlPropertySourceFactory;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Configuration
@PropertySource(value = "classpath:currencycom.yml", factory = YamlPropertySourceFactory.class)
public class CurrencyComApiProperties {

  @Value("${api.hostApiUrl}")
  private String hostApiUrl;
  @Value("${api.demoHostApiUrl}")
  private String demoHostApiUrl;
}
