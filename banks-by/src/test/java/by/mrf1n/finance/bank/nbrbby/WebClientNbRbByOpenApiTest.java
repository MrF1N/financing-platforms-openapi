package by.mrf1n.finance.bank.nbrbby;

import by.mrf1n.finance.bank.nbrbby.context.NbRbByContext;
import by.mrf1n.finance.bank.nbrbby.model.Currency;
import by.mrf1n.finance.bank.nbrbby.model.DynamicOfRateRequest;
import by.mrf1n.finance.bank.nbrbby.model.RateShort;
import by.mrf1n.finance.bank.nbrbby.model.enums.Periodicity;
import by.mrf1n.finance.bank.nbrbby.model.rate.ByInternalCodeRateRequest;
import by.mrf1n.finance.bank.nbrbby.model.rate.ByIsoAbbreviationCodeRateRequest;
import by.mrf1n.finance.bank.nbrbby.model.rate.ByIsoNumberCodeRateRequest;
import by.mrf1n.finance.bank.nbrbby.model.rate.ByPeriodicityRateRequest;
import by.mrf1n.finance.bank.nbrbby.model.rate.Rate;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@ContextConfiguration(classes = {NbRbByOpenApiTestConfig.class})
@SpringBootTest
@RequiredArgsConstructor
public class WebClientNbRbByOpenApiTest {

    private final NbRbByContext nbRbByContext;

    @Test
    public void getAllCurrenciesTest() {
        List<Currency> response = nbRbByContext.getAllCurrencies();
        System.out.println(response);
        Assert.notEmpty(response, "List<Currency> shouldn't be empty");
    }

    @Test
    public void getCurrencyByIdTest() {
        Currency response = nbRbByContext.getCurrencyById(431);
        System.out.println(response);
        Assert.notNull(response, "Currency shouldn't be null");
    }

    @Test
    public void getRatesByPeriodicityTest() throws ParseException {
        ByPeriodicityRateRequest request = ByPeriodicityRateRequest.builder()
                .periodicity(Periodicity.DAILY)
                .onDate(new SimpleDateFormat("dd.MM.yyyy").parse("02.02.2022"))
                .build();
        List<Rate> response = nbRbByContext.getRatesByPeriodicity(request);
        System.out.println(response);
        Assert.notEmpty(response, "List<Rate> shouldn't be empty");
    }

    @Test
    public void getRateByInternalCodeTest() throws ParseException {
        ByInternalCodeRateRequest request = ByInternalCodeRateRequest.builder()
                .currencyCode("431")
                .onDate(new SimpleDateFormat("dd.MM.yyyy").parse("02.02.2022"))
                .build();
        Rate response = nbRbByContext.getRateByCode(request);
        System.out.println(response);
        Assert.notNull(response, "Rate shouldn't be null");
    }

    @Test
    public void getRateByIsoNumberCodeTest() throws ParseException {
        ByIsoNumberCodeRateRequest request = ByIsoNumberCodeRateRequest.builder()
                .currencyCode("840")
                .onDate(new SimpleDateFormat("dd.MM.yyyy").parse("02.02.2022"))
                .build();
        Rate response = nbRbByContext.getRateByCode(request);
        System.out.println(response);
        Assert.notNull(response, "Rate shouldn't be null");
    }

    @Test
    public void getRateByIsoAbbreviationCodeTest() throws ParseException {
        ByIsoAbbreviationCodeRateRequest request = ByIsoAbbreviationCodeRateRequest.builder()
                .currencyCode("USD")
                .onDate(new SimpleDateFormat("dd.MM.yyyy").parse("02.02.2022"))
                .build();
        Rate response = nbRbByContext.getRateByCode(request);
        System.out.println(response);
        Assert.notNull(response, "Rate shouldn't be null");
    }

    @Test
    public void getRateByDateRangeTest() throws ParseException {
        DynamicOfRateRequest request = DynamicOfRateRequest.builder()
                .currencyId(431)
                .startDate(new SimpleDateFormat("dd.MM.yyyy").parse("02.02.2022"))
                .endDate(new SimpleDateFormat("dd.MM.yyyy").parse("20.02.2022"))
                .build();
        List<RateShort> response = nbRbByContext.getRateByDateRange(request);
        System.out.println(response);
        Assert.notEmpty(response, "List<RateShort> shouldn't be empty");
    }
}
