package by.mrf1n.finance.bank;

import by.mrf1n.finance.bank.alfabankby.context.AlfaByPublicContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebClientBanksByOpenApi implements BanksByOpenApi {

    private final AlfaByPublicContext alfaByPublicContextImpl;

    @Override
    public void close() {
    }

    @Override
    public AlfaByPublicContext getAlfaByPublicContext() {
        return alfaByPublicContextImpl;
    }
}
