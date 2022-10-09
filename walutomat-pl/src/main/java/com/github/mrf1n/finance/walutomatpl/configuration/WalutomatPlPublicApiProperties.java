package com.github.mrf1n.finance.walutomatpl.configuration;

import by.mrf1n.finance.common.YamlPropertySourceFactory;
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
@PropertySource(value = "classpath:walutomatpl.yml", factory = YamlPropertySourceFactory.class)
public class WalutomatPlPublicApiProperties {

  @Value("${walutomat.api.public-api-url}")
  private String publicApiUrl;
  @Value("${walutomat.path.currencies}")
  private String currencies;
  @Value("${walutomat.path.currency}")
  private String currency;
}
