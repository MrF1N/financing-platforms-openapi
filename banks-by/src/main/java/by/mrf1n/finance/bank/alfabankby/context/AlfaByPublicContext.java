package by.mrf1n.finance.bank.alfabankby.context;

import by.mrf1n.finance.bank.alfabankby.model.BankListRequest;
import by.mrf1n.finance.bank.alfabankby.model.BankListResponse;
import by.mrf1n.finance.bank.alfabankby.model.NationalRateListRequest;
import by.mrf1n.finance.bank.alfabankby.model.NationalRateListResponse;
import by.mrf1n.finance.bank.alfabankby.model.RateListResponse;

public interface AlfaByPublicContext {

    BankListResponse getBankList(BankListRequest request);

    NationalRateListResponse getNationalRateList(NationalRateListRequest request);

    RateListResponse getBankRateList();
}
