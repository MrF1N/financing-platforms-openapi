package by.mrf1n.finance.currencycom.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Ticker24HResponse implements Serializable {

    private String askPrice;
    private String bidPrice;
    private BigInteger closeTime;
    private String highPrice;
    private String lastPrice;
    private String lastQty;
    private String lowPrice;
    private String openPrice;
    private BigInteger openTime;
    private String prevClosePrice;
    private String priceChange;
    private String priceChangePercent;
    private String quoteVolume;
    private String symbol;
    private String volume;
    private String weightedAvgPrice;
}
