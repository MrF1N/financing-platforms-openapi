package by.mrf1n.finance.bank;

import by.mrf1n.finance.bank.alfabankby.context.AlfaByPublicContext;

import java.io.Closeable;

public interface BanksByOpenApi extends Closeable {

    AlfaByPublicContext getAlfaByPublicContext();
}
