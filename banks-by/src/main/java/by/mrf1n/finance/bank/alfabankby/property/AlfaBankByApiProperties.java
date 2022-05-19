package by.mrf1n.finance.bank.alfabankby.property;

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
@PropertySource(value = "classpath:alfabankby.yml", factory = YamlPropertySourceFactory.class)
public class AlfaBankByApiProperties {

    @Value("${api.baseUrl}")
    private String baseUrl;

    @Value("${paths.bankCode}")
    private String bankCode;
    @Value("${paths.nationalRates}")
    private String nationalRates;
    @Value("${paths.rates}")
    private String rates;
}
