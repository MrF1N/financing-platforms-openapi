package com.github.mrf1n.finance.walutomatpl.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferRate implements Serializable {

    @JsonProperty("ask_now")
    private Float buyingPrice;
    @JsonProperty("bid_now")
    private Float sellingPrice;
    @JsonProperty("forex_now")
    private Float forexPrice;
    @JsonProperty("ask_old")
    private Float oldBuyingPrice;
    @JsonProperty("bid_old")
    private Float oldSellingPrice;
    @JsonProperty("forex_old")
    private Float oldForexPrice;
}
