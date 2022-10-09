package by.mrf1n.finance.bank.nbrbby;

import by.mrf1n.finance.bank.nbrbby.property.NbRbByApiProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Import({NbRbByApiProperties.class})
@ComponentScan(basePackages = {"by.mrf1n.finance.bank.nbrbby"})
@RequiredArgsConstructor
public class NbRbByOpenApiConfig {
    protected final NbRbByApiProperties nbRbByApiProperties;

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
}
