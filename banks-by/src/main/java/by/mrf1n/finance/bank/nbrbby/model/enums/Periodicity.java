package by.mrf1n.finance.bank.nbrbby.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Periodicity {

    @JsonProperty("0")
    DAILY(0),
    @JsonProperty("1")
    YEARLY(1);

    private final Integer code;

    Periodicity(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code.toString();
    }
}
