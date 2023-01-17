package com.github.mrf1n.finance.walutomatpl;

import com.github.mrf1n.finance.walutomatpl.context.WalutomatPlPublicApiContext;
import com.github.mrf1n.finance.walutomatpl.context.WalutomatPlRegularApiContext;

public interface WalutomatPlOpenApi {

    WalutomatPlPublicApiContext getPublicApiContext();
    WalutomatPlRegularApiContext getRegularApiContext();
}
