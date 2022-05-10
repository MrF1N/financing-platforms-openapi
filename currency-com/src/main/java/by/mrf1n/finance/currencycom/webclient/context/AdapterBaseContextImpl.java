package by.mrf1n.finance.currencycom.webclient.context;

import by.mrf1n.finance.currencycom.property.CurrencyComAdapterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;


public abstract class AdapterBaseContextImpl extends BaseContextImpl{

    protected CurrencyComAdapterProperties adapterProps;

    public AdapterBaseContextImpl(String authKey, String authSecret) {
        super(authKey, authSecret);
    }

    @Autowired
    public void setCurrencyComAdapterProperties(CurrencyComAdapterProperties adapterProperties) {
        this.adapterProps = adapterProperties;
    }

    @Autowired
    public void setClient(WebClient adapterWebClient) {
        this.client = adapterWebClient;
    }
}
