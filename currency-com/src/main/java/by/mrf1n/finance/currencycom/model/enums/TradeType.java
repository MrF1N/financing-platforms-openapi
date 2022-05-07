package by.mrf1n.finance.currencycom.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TradeType {
    @JsonProperty("sell")
    SELL("sell"),
    @JsonProperty("buy")
    BUY("buy");

    private final String type;

    TradeType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
