package by.mrf1n.finance.currencycom.webclient.context.adapter;

import by.mrf1n.finance.currencycom.context.AccountContext;
import by.mrf1n.finance.currencycom.model.AccountRequest;
import by.mrf1n.finance.currencycom.model.AccountResponse;
import by.mrf1n.finance.currencycom.model.FundingLimitsDtoResponse;
import by.mrf1n.finance.currencycom.model.TransactionsRequest;
import by.mrf1n.finance.currencycom.model.TransactionsResponse;
import by.mrf1n.finance.currencycom.webclient.context.AdapterBaseContextImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
                        this.createUriWithSignature(
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

    @Override
    public TransactionsResponse getListOfDeposits(TransactionsRequest request) {
        return this.client.get()
                .uri(uriBuilder ->
                        this.createUriWithSignature(
                                this.buildWithTime(uriBuilder, adapterProps.getListOfDeposits(), request.getTimestamp())
                                        .queryParamIfPresent("recvWindow", Optional.ofNullable(request.getRecvWindow()))
                                        .queryParamIfPresent("startTime", Optional.ofNullable(request.getStartTime()))
                                        .queryParamIfPresent("endTime", Optional.ofNullable(request.getEndTime()))
                                        .queryParamIfPresent("limit", Optional.ofNullable(request.getLimit()))
                                        .build()
                        )
                )
                .retrieve()
                .bodyToMono(TransactionsResponse.class)
                .block();
    }

    @Override
    public List<FundingLimitsDtoResponse> getFundingLimits() {
        return this.client.get()
                .uri(uriBuilder ->
                        this.createUriWithSignature(
                                this.buildWithTime(uriBuilder, adapterProps.getListOfFundingLimits(), null)
                                        .build()
                        )
                )
                .retrieve()
                .bodyToFlux(FundingLimitsDtoResponse.class)
                .collectList()
                .block();
    }

    @Override
    public TransactionsResponse getListOfWithdrawals(TransactionsRequest request) {
        return this.client.get()
                .uri(uriBuilder ->
                        this.createUriWithSignature(
                                this.buildWithTime(uriBuilder, adapterProps.getListOfWithdrawals(), request.getTimestamp())
                                        .queryParamIfPresent("recvWindow", Optional.ofNullable(request.getRecvWindow()))
                                        .queryParamIfPresent("startTime", Optional.ofNullable(request.getStartTime()))
                                        .queryParamIfPresent("endTime", Optional.ofNullable(request.getEndTime()))
                                        .queryParamIfPresent("limit", Optional.ofNullable(request.getLimit()))
                                        .build()
                        )
                )
                .retrieve()
                .bodyToMono(TransactionsResponse.class)
                .block();
    }
}
