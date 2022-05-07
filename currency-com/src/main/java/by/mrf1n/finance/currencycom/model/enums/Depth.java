package by.mrf1n.finance.currencycom.model.enums;

public enum Depth {

    ZERO(0),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500);

    private final Integer depth;

    Depth(Integer depth) {
        this.depth = depth;
    }

    public Integer getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return depth.toString();
    }
}
