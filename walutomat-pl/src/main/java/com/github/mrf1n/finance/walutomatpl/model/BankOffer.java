package com.github.mrf1n.finance.walutomatpl.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankOffer {

    @JsonProperty("bank_id")
    private String bankId;
    private Double amount;
    private Float rate;
    private Float fee;
    @JsonProperty("bank_display_name")
    private String bankName;
}
