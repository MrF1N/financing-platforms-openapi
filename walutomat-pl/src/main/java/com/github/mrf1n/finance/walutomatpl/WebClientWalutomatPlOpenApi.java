package com.github.mrf1n.finance.walutomatpl;

import com.github.mrf1n.finance.walutomatpl.context.WalutomatPlPublicApiContext;
import com.github.mrf1n.finance.walutomatpl.context.WebClientWalutomatPlPublicApiContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebClientWalutomatPlOpenApi implements WalutomatPlOpenApi {

    private final WebClientWalutomatPlPublicApiContext publicApiContext;

    @Override
    public WalutomatPlPublicApiContext getPublicApiContext() {
        return publicApiContext;
    }
}
