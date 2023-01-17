package com.github.mrf1n.finance.walutomatpl.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Import({WalutomatPlApiProperties.class})
@ComponentScan(basePackages = {"com.github.mrf1n.finance.walutomatpl"})
@RequiredArgsConstructor
public class WalutomatPlOpenApiConfig {

    protected final WalutomatPlApiProperties walutomatApiProps;

    @Bean
    public String walutomatPublicApiUrl() {
        return walutomatApiProps.getPublicApiUrl();
    }

    @Bean
    public String walutomatRegularApiUrl() {
        return walutomatApiProps.getRegularApiUrl();
    }

    @Bean
    public WebClient walutomatPlPublicWebClient(String walutomatPublicApiUrl) {
        return WebClient
                .builder()
                .baseUrl(walutomatPublicApiUrl)
                .build();
    }

    @Bean
    public WebClient walutomatPlRegularWebClient(String walutomatRegularApiUrl) {
        return WebClient
                .builder()
                .baseUrl(walutomatRegularApiUrl)
                .build();
    }
}
