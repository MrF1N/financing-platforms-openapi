package by.mrf1n.finance.bank.alfabankby;

import by.mrf1n.finance.bank.alfabankby.property.AlfaBankByApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.function.client.WebClient;

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
    public WebClient alfaBankByWebClient() {
        return WebClient
                .builder()
                .baseUrl(this.alfaByApiUrl())
                .build();
    }

    @Autowired
    public void setAlfaBankByApiProps(AlfaBankByApiProperties alfaBankByApiProps) {
        this.alfaBankByApiProps = alfaBankByApiProps;
    }
}
