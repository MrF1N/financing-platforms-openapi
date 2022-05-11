package by.mrf1n.finance.currencycom.model.serialization;

import by.mrf1n.finance.currencycom.model.CurrencyDtoResponse;
import by.mrf1n.finance.currencycom.model.CurrencyResponse;
import by.mrf1n.finance.currencycom.model.enums.CurrencyType;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CurrencyResponseDeserializer extends StdDeserializer<CurrencyResponse> {

    public CurrencyResponseDeserializer() {
        this(null);
    }

    protected CurrencyResponseDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public CurrencyResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ArrayNode arrayNode = jp.getCodec().readTree(jp);
        List<CurrencyDtoResponse> currencyDtoResponses = new ArrayList<>();
        arrayNode.forEach(node -> {
            Double commissionFixed = node.get("commissionFixed") == null ? null : node.get("commissionFixed").doubleValue();
            Double commissionMin = node.get("commissionMin") == null ? null : node.get("commissionMin").doubleValue();
            Double commissionPercent = node.get("commissionPercent") == null ? null : node.get("commissionPercent").doubleValue();
            String displaySymbol = node.get("displaySymbol").asText();
            Double maxWithdrawal = node.get("maxWithdrawal") == null ? null : node.get("maxWithdrawal").doubleValue();
            Double minDeposit = node.get("minDeposit") == null ? null : node.get("minDeposit").doubleValue();
            Double minWithdrawal = node.get("minWithdrawal") == null ? null : node.get("minWithdrawal").doubleValue();
            String name = node.get("name").asText();
            Integer precision = node.get("precision") == null ? null : node.get("precision").intValue();
            CurrencyType type = CurrencyType.valueOf(node.get("type").asText());
            currencyDtoResponses.add(new CurrencyDtoResponse(
                    commissionFixed,
                    commissionMin,
                    commissionPercent,
                    displaySymbol,
                    maxWithdrawal,
                    minDeposit,
                    minWithdrawal,
                    name,
                    precision,
                    type));
        });
        return new CurrencyResponse(currencyDtoResponses);
    }
}
