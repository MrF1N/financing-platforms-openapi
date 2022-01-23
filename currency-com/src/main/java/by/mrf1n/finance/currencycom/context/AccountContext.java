package by.mrf1n.finance.currencycom.context;

import by.mrf1n.finance.currencycom.model.AccountRequest;
import by.mrf1n.finance.currencycom.model.AccountResponse;

public interface AccountContext {

  public AccountResponse getAccountInfo(AccountRequest request);

}
