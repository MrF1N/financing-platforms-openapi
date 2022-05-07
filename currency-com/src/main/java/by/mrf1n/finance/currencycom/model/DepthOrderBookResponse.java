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
public class DepthOrderBookResponse implements Serializable {
    private List<List<Double>> asks;
    private List<List<Double>> bids;
    private BigInteger timestamp;
}