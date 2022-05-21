package by.mrf1n.finance.bank.nbrbby;

import by.mrf1n.finance.bank.alfabankby.property.AlfaBankByApiProperties;
import by.mrf1n.finance.bank.nbrbby.property.NbRbByApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Configuration
@Import({NbRbByApiProperties.class})
@ComponentScan(basePackages = {"by.mrf1n.finance.bank.nbrbby"})
public class NbRbByOpenApiConfig {
    protected NbRbByApiProperties nbRbByApiProperties;

    @Bean
    public String nbrbByApiUrl() {
        return nbRbByApiProperties.getBaseUrl();
    }

    @Bean
    public WebClient nbRbByWebClient(String nbrbByApiUrl) {
        return WebClient
                .builder()
                .baseUrl(nbrbByApiUrl)
                .build();
    }

    @Autowired
    public void setNbRbByApiProperties(NbRbByApiProperties nbRbByApiProperties) {
        this.nbRbByApiProperties = nbRbByApiProperties;
    }
}
