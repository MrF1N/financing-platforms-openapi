package by.mrf1n.finance.bank;

import by.mrf1n.finance.bank.alfabankby.context.AlfaByPublicContext;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Closeable;

@ToString
@EqualsAndHashCode
public abstract class BanksByOpenApi implements Closeable {

    protected AlfaByPublicContext alfaByPublicContext;

    public AlfaByPublicContext getAlfaByPublicContext() {
        return alfaByPublicContext;
    }

    public abstract void setAlfaByPublicContext(AlfaByPublicContext alfaByPublicContext);
}
