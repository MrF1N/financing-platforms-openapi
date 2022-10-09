package com.github.mrf1n.finance.walutomatpl.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeByTime implements Serializable {

    @JsonProperty("ts")
    private Date timestamp;
    private Float price;
    private Double volume;
}
