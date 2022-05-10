package by.mrf1n.finance.currencycom.webclient.context.adapter;

import by.mrf1n.finance.currencycom.context.AccountContext;
import by.mrf1n.finance.currencycom.model.AccountRequest;
import by.mrf1n.finance.currencycom.model.AccountResponse;
import by.mrf1n.finance.currencycom.webclient.context.AdapterBaseContextImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Component
public class AccountContextImpl extends AdapterBaseContextImpl implements AccountContext {

    @Autowired
    public AccountContextImpl(String authKey, String authSecret) {
        super(authKey, authSecret);
    }

    @Override
    public AccountResponse getAccountInfo(AccountRequest request) {
        return this.client.get()
                .uri(uriBuilder ->
                        this.createURIWithSignature(
                                this.buildWithTime(uriBuilder, adapterProps.getAccountInfo(), request.getTimestamp())
                                        .queryParamIfPresent("recvWindow", Optional.ofNullable(request.getRecvWindow()))
                                        .queryParamIfPresent("showZeroBalance", Optional.ofNullable(request.getShowZeroBalance()))
                                        .build()
                        )
                )
                .retrieve()
                .bodyToMono(AccountResponse.class)
                .block();
    }
}
