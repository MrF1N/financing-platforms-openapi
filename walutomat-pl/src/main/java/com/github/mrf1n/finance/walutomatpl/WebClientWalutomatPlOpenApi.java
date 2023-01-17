package com.github.mrf1n.finance.walutomatpl;

import com.github.mrf1n.finance.walutomatpl.context.WalutomatPlPublicApiContext;
import com.github.mrf1n.finance.walutomatpl.context.WalutomatPlRegularApiContext;
import com.github.mrf1n.finance.walutomatpl.context.WebClientWalutomatPlPublicApiContext;
import com.github.mrf1n.finance.walutomatpl.context.WebClientWalutomatPlRegularApiContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebClientWalutomatPlOpenApi implements WalutomatPlOpenApi {

    private final WebClientWalutomatPlPublicApiContext publicApiContext;
    private final WebClientWalutomatPlRegularApiContext regularApiContext;

    @Override
    public WalutomatPlPublicApiContext getPublicApiContext() {
        return publicApiContext;
    }

    @Override
    public WalutomatPlRegularApiContext getRegularApiContext() {
        return regularApiContext;
    }
}
