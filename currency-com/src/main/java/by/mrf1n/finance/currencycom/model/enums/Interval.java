package by.mrf1n.finance.currencycom.model.enums;

public enum Interval {

    M1("1m"),
    M3("3m"),
    M5("5m"),
    M10("10m"),
    M15("15m"),
    M30("30m"),
    H1("1h"),
    H4("4h"),
    D1("1d"),
    W1("1w");

    private final String interval;

    Interval(String interval) {
        this.interval = interval;
    }

    public String getInterval() {
        return interval;
    }

    public String getCandlesInterval() {
        return name();
    }

    @Override
    public String toString() {
        return interval;
    }
}
