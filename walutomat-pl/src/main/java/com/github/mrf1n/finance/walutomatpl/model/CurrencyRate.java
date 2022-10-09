package com.github.mrf1n.finance.walutomatpl.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRate implements Serializable {

    @JsonProperty("pair")
    private String pairName;
    private OfferRate bestOffers;
    private List<ExchangeByTime> lastExchanges;
    private List<ExchangeByDay> dayExchanges;
}
