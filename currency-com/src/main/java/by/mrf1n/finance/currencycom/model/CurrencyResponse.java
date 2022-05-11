package by.mrf1n.finance.currencycom.model;

import by.mrf1n.finance.currencycom.model.serialization.AggTradesResponseDeserializer;
import by.mrf1n.finance.currencycom.model.serialization.CurrencyResponseDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@JsonDeserialize(using = CurrencyResponseDeserializer.class)
public class CurrencyResponse implements Serializable {

    private List<CurrencyDtoResponse> currencies;
}
