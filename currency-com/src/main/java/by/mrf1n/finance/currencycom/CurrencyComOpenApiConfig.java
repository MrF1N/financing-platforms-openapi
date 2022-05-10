package by.mrf1n.finance.currencycom;

import by.mrf1n.finance.currencycom.property.CurrencyComAdapterProperties;
import by.mrf1n.finance.currencycom.property.CurrencyComApiUrlProperties;
import by.mrf1n.finance.currencycom.property.CurrencyComMarketProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.function.BodyExtractor;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Import({CurrencyComAdapterProperties.class,
        CurrencyComApiUrlProperties.class,
        CurrencyComMarketProperties.class})
@ComponentScan(basePackages = {"by.mrf1n.finance.currencycom.webclient"})
public class CurrencyComOpenApiConfig {

    protected CurrencyComApiUrlProperties apiProperties;

    @Bean
    public String authKey() {
        return "";
    }

    @Bean
    public String authSecret() {
        return "";
    }

    @Bean
    public boolean sandboxMode() {
        return true;
    }

    @Bean
    public String apiUrl() {
        return sandboxMode() ? apiProperties.getDemoAdapterApiUrl() : apiProperties.getAdapterApiUrl();
    }

    @Bean
    public String apiVersion() {
        return "v2";
    }

    @Bean
    public WebClient adapterWebClient(WebClient.Builder builder, String authKey, String apiVersion) {
        return builder
                .baseUrl(this.apiProperties.getAdapterApiUrl())
                .defaultUriVariables(Map.of("apiVersion", apiVersion))
                .defaultHeader("X-MBX-APIKEY", authKey)
                .build();
    }

    @Bean
    public WebClient marketCryptoWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl(this.apiProperties.getMarketCryptoApiUrl())
                .build();
    }

    @Bean
    public WebClient marketTokenCryptoWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl(this.apiProperties.getMarketTokenCryptoApiUrl())
                .build();
    }

    @Bean
    public WebClient marketTokenWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl(this.apiProperties.getMarketTokenApiUrl())
                .build();
    }

    @Bean
    public WebClient.Builder builder() {
        return WebClient
                .builder()
                .codecs(conf -> conf.defaultCodecs()
                        .maxInMemorySize(10 * 1024 * 1024));
    }

    @Autowired
    public CurrencyComOpenApiConfig(CurrencyComApiUrlProperties apiProperties) {
        this.apiProperties = apiProperties;
    }
}
