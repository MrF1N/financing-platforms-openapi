package by.mrf1n.finance.bank.alfabankby;

import by.mrf1n.finance.bank.alfabankby.property.AlfaBankByApiProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Configuration
@Import({AlfaBankByApiProperties.class})
@ComponentScan(basePackages = {"by.mrf1n.finance.bank.alfabankby"})
@RequiredArgsConstructor
public class AlfaBankByOpenApiConfig {

    protected final AlfaBankByApiProperties alfaBankByApiProps;

    @Bean
    public String alfaByApiUrl() {
        return alfaBankByApiProps.getBaseUrl();
    }

    @Bean
    public String alfaByApiVersion() {
        return alfaBankByApiProps.getApiVersion();
    }

    @Bean
    public WebClient alfaBankByWebClient(String alfaByApiUrl, String alfaByApiVersion) {
        return WebClient
                .builder()
                .baseUrl(alfaByApiUrl)
                .defaultUriVariables(Map.of("alfaByApiVer", alfaByApiVersion))
                .build();
    }
}
