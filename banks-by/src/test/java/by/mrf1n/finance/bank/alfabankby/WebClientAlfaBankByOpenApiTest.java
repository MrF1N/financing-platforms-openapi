package by.mrf1n.finance.bank.alfabankby;

import by.mrf1n.finance.bank.alfabankby.context.AlfaByPublicContext;
import by.mrf1n.finance.bank.alfabankby.model.BankListRequest;
import by.mrf1n.finance.bank.alfabankby.model.BankListResponse;
import by.mrf1n.finance.bank.alfabankby.model.NationalRateListRequest;
import by.mrf1n.finance.bank.alfabankby.model.NationalRateListResponse;
import by.mrf1n.finance.bank.alfabankby.model.RateListResponse;
import by.mrf1n.finance.bank.alfabankby.model.enums.CountryType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@ContextConfiguration(classes = {AlfaBankByOpenApiTestConfig.class})
@SpringBootTest
public class WebClientAlfaBankByOpenApiTest {

    private AlfaByPublicContext alfaByPublicContext;

    @Test
    public void getBankListTest() {
        BankListRequest request = BankListRequest.builder()
                .type(CountryType.BY)
                .pageNo(0)
                .pageRowCount(0)
                .build();
        BankListResponse response = alfaByPublicContext.getBankList(request);
        System.out.println(response);
        Assert.notNull(response, "BankListResponse shouldn't be null");
    }

    @Test
    public void getNationalRateListTest() {
        NationalRateListRequest request = NationalRateListRequest.builder()
                .date(new Date())
                .currencyCode(List.of(8,51))
                .build();
        NationalRateListResponse response = alfaByPublicContext.getNationalRateList(request);
        System.out.println(response);
        Assert.notNull(response, "NationalRateListResponse shouldn't be null");
    }

    @Test
    public void getBankRateListTest() {
        RateListResponse response = alfaByPublicContext.getBankRateList();
        System.out.println(response);
        Assert.notNull(response, "RateListResponse shouldn't be null");
    }

    @Autowired
    public void setAlfaByPublicContext(AlfaByPublicContext alfaByPublicContext) {
        this.alfaByPublicContext = alfaByPublicContext;
    }
}
