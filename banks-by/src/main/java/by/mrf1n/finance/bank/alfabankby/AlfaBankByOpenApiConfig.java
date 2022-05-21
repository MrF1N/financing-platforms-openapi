package by.mrf1n.finance.bank.alfabankby;

import by.mrf1n.finance.bank.alfabankby.property.AlfaBankByApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Configuration
@Import({AlfaBankByApiProperties.class})
@ComponentScan(basePackages = {"by.mrf1n.finance.bank.alfabankby"})
public class AlfaBankByOpenApiConfig {

    protected AlfaBankByApiProperties alfaBankByApiProps;

    @Bean
    public String alfaByApiUrl() {
        return alfaBankByApiProps.getBaseUrl();
    }

    @Bean
    public String alfaByApiVersion() {
        return "1.0.1";
    }

    @Bean
    public WebClient alfaBankByWebClient(String alfaByApiUrl, String alfaByApiVersion) {
        return WebClient
                .builder()
                .baseUrl(alfaByApiUrl)
                .defaultUriVariables(Map.of("alfaByApiVer", alfaByApiVersion))
                .build();
    }

    @Autowired
    public void setAlfaBankByApiProps(AlfaBankByApiProperties alfaBankByApiProps) {
        this.alfaBankByApiProps = alfaBankByApiProps;
    }
}
