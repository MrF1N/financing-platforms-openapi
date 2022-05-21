package by.mrf1n.finance.bank.nbrbby.model.enums;

public enum CurrencyIdMode {

    INTERNAL,
    ISO_NUMBER,
    ISO_CODE;

    @Override
    public String toString() {
        return String.valueOf(this.ordinal());
    }
}
