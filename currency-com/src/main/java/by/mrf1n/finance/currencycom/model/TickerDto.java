package by.mrf1n.finance.currencycom.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class TickerDto implements Serializable {

    private String base_currency;
    private String quote_currency;
    private String description;
    private Double last_price;
    private Double quote_volume;
    private Double base_volume;
    private Boolean isFrozen;
    private Double past_24hrs_high_price;
    private Double past_24hrs_low_price;
    private Double past_24hrs_price_change;
    private Double lowest_ask_price;
    private Double highest_bid_price;
}