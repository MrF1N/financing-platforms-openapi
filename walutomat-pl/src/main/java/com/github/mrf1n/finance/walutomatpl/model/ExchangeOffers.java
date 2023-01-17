package com.github.mrf1n.finance.walutomatpl.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeOffers {

    @JsonProperty("exchange_offers")
    private List<BankOffer> exchangeOffers;
    private String type;
    @JsonProperty("currency_name")
    private String currencyName;
}
