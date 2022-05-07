package by.mrf1n.finance.currencycom.model;

import by.mrf1n.finance.currencycom.model.serialization.OHLCResponseDeserializer;
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
@JsonDeserialize(using = OHLCResponseDeserializer.class)
public class OHLCResponse implements Serializable {

    private List<String> error;
    private OHLCResponseResult result;
}
