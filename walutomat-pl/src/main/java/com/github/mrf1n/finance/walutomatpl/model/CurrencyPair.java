package com.github.mrf1n.finance.walutomatpl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyPair {

    private String leftCur;
    private String rightCur;

    public CurrencyPair(String pairName) {
        this.leftCur = pairName.substring(0, 3);
        this.rightCur = pairName.substring(3);
    }

    public String getPairName()
    {
        return getPairName("");
    }

    public String getPairName(String separator)
    {
        return leftCur + separator + rightCur;
    }

    public String getUnderScorePairName()
    {
        return getPairName("_");
    }

}
