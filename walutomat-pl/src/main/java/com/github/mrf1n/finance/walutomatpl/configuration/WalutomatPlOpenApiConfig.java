package com.github.mrf1n.finance.walutomatpl.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Import({WalutomatPlPublicApiProperties.class})
@ComponentScan(basePackages = {"com.github.mrf1n.finance.walutomatpl"})
@RequiredArgsConstructor
public class WalutomatPlOpenApiConfig {

    protected final WalutomatPlPublicApiProperties walutomatPublicApiProps;

    @Bean
    public String walutomatPublicApiUrl() {
        return walutomatPublicApiProps.getPublicApiUrl();
    }

    @Bean
    public WebClient walutomatPlWebClient(String walutomatPublicApiUrl) {
        return WebClient
                .builder()
                .baseUrl(walutomatPublicApiUrl)
                .build();
    }
}
