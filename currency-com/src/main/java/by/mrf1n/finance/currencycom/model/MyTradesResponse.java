package by.mrf1n.finance.currencycom.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class MyTradesResponse implements Serializable {

    private Boolean buyer;
    private String commission;
    private String commissionAsset;
    private String id;
    private Boolean isBuyer;
    private Boolean isMaker;
    private Boolean maker;
    private String orderId;
    private String price;
    private String qty;
    private String quoteQty;
    private String symbol;
    private BigInteger time;
}
