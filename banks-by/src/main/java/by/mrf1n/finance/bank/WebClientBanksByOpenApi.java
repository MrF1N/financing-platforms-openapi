package by.mrf1n.finance.bank;

import by.mrf1n.finance.bank.alfabankby.context.AlfaByPublicContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WebClientBanksByOpenApi extends BanksByOpenApi {

    @Autowired
    @Qualifier("alfaByPublicContextImpl")
    public void setAlfaByPublicContext(AlfaByPublicContext alfaByPublicContext) {
        this.alfaByPublicContext = alfaByPublicContext;
    }

    @Override
    public void close() {
    }
}
