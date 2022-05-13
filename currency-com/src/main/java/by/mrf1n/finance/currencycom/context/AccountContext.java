package by.mrf1n.finance.currencycom.context;

import by.mrf1n.finance.currencycom.model.AccountRequest;
import by.mrf1n.finance.currencycom.model.AccountResponse;
import by.mrf1n.finance.currencycom.model.TransactionsRequest;
import by.mrf1n.finance.currencycom.model.TransactionsResponse;

public interface AccountContext {

  AccountResponse getAccountInfo(AccountRequest request);

  TransactionsResponse getListOfDeposits(TransactionsRequest request);

}
