package by.mrf1n.finance.bank;

import by.mrf1n.finance.bank.alfabankby.AlfaBankByOpenApiConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AlfaBankByOpenApiConfig.class})
public class BanksByOpenApiConfig {
}
