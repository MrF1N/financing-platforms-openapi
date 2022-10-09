package com.github.mrf1n.finance.walutomatpl;

import com.github.mrf1n.finance.walutomatpl.configuration.WalutomatPlOpenApiConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WalutomatPlOpenApiConfig.class)
public class WalutomatPlOpenApiTestConfig {
}
