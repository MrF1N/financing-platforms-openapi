package by.mrf1n.finance.bank.nbrbby.property;

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
@PropertySource(value = "classpath:nbrbby.yml", factory = YamlPropertySourceFactory.class)
public class NbRbByApiProperties {

    @Value("${api.baseUrl}")
    private String baseUrl;

    @Value("${paths.currencies}")
    private String currencies;
    @Value("${paths.currenciesById}")
    private String currenciesById;
    @Value("${paths.rates}")
    private String rates;
    @Value("${paths.rateByCode}")
    private String rateByCode;
    @Value("${paths.dynamicsOfRate}")
    private String dynamicsOfRate;
}
