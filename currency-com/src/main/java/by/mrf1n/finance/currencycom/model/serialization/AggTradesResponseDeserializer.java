package by.mrf1n.finance.currencycom.model.serialization;

import by.mrf1n.finance.currencycom.model.AggTrades;
import by.mrf1n.finance.currencycom.model.AggTradesResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AggTradesResponseDeserializer extends StdDeserializer<AggTradesResponse> {

    public AggTradesResponseDeserializer() {
        this(null);
    }

    protected AggTradesResponseDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public AggTradesResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ArrayNode arrayNode = jp.getCodec().readTree(jp);
        List<AggTrades> trades = new ArrayList<>();
        arrayNode.forEach(node -> {
            BigInteger T = BigInteger.valueOf(node.get("T").longValue());
            BigInteger a = BigInteger.valueOf(node.get("a").longValue());
            Boolean m = node.get("m").booleanValue();
            String p = node.get("p").asText();
            String q = node.get("q").asText();
            trades.add(new AggTrades(T,a,m,p,q));
        });
        return new AggTradesResponse(trades);
    }
}
