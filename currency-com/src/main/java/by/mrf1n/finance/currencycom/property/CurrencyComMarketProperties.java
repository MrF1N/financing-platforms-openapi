package by.mrf1n.finance.currencycom.property;

import by.mrf1n.finance.currencycom.common.YamlPropertySourceFactory;
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
@PropertySource(value = "classpath:currencycom.yml", factory = YamlPropertySourceFactory.class)
public class CurrencyComMarketProperties {

    @Value("${marketcap-paths.listOfAssets}")
    private String listOfAssets;
    @Value("${marketcap-paths.candlesData}")
    private String candlesData;
    @Value("${marketcap-paths.OHLC}")
    private String OHLC;
    @Value("${marketcap-paths.orderbook}")
    private String orderbook;
    @Value("${marketcap-paths.marketData}")
    private String marketData;
    @Value("${marketcap-paths.priceChange}")
    private String priceChange;
    @Value("${marketcap-paths.listOfTrades}")
    private String listOfTrades;
}
