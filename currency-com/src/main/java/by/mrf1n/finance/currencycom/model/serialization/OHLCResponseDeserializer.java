package by.mrf1n.finance.currencycom.model.serialization;

import by.mrf1n.finance.currencycom.model.OHLCResponse;
import by.mrf1n.finance.currencycom.model.OHLCResponseResult;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class OHLCResponseDeserializer extends StdDeserializer<OHLCResponse> {

    public OHLCResponseDeserializer() {
        this(null);
    }

    public OHLCResponseDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public OHLCResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        JsonNode resultNode = node.get("result");
        List<String> error = StreamSupport.stream(node.get("error").spliterator(), false)
                .map(JsonNode::asText)
                .toList();
        List<List<Double>> results = new ArrayList<>();
        resultNode.elements().next().forEach(nd -> {
            List<Double> collect = StreamSupport.stream(nd.spliterator(), false)
                    .map(JsonNode::asDouble)
                    .toList();
            results.add(collect);
        });
        Double last = resultNode.get("last").asDouble();
        return new OHLCResponse(error, new OHLCResponseResult(results, last));
    }
}
