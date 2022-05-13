package by.mrf1n.finance.currencycom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class LeverageSettingsRequest {

    private String apiKey;
    private BigInteger recvWindow;
    private String signature;
    private String symbol;
    private BigInteger timestamp;
}
