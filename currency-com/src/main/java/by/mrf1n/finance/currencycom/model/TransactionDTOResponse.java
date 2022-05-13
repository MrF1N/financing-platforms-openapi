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
public class TransactionDTOResponse implements Serializable {

    private Double amount;
    private Double balance;
    private String blockchainTransactionHash;
    private Double commission;
    private String currency;
    private BigInteger id;
    private String paymentMethod;
    private String status;
    private BigInteger timestamp;
    private String type;
}
