package by.mrf1n.finance.currencycom.model.serialization;

import by.mrf1n.finance.currencycom.model.TransactionDTOResponse;
import by.mrf1n.finance.currencycom.model.TransactionsResponse;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TransactionsResponseDeserializer extends StdDeserializer<TransactionsResponse> {

    public TransactionsResponseDeserializer() {
        this(null);
    }

    protected TransactionsResponseDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public TransactionsResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ArrayNode arrayNode = jp.getCodec().readTree(jp);
        List<TransactionDTOResponse> transactionDTOResponses = new ArrayList<>();
        arrayNode.forEach(node -> {
            Double amount = node.get("amount").doubleValue();
            Double balance = node.get("balance").doubleValue();
            String blockchainTransactionHash = node.get("blockchainTransactionHash") == null ? null : node.get("blockchainTransactionHash").asText();
            Double commission = node.get("commission").doubleValue();
            String currency = node.get("currency").asText();
            BigInteger id = node.get("id").bigIntegerValue();
            String paymentMethod = node.get("paymentMethod") == null ? null : node.get("paymentMethod").asText();
            String status = node.get("status").asText();
            BigInteger timestamp = node.get("timestamp").bigIntegerValue();
            String type = node.get("type").asText();
            transactionDTOResponses.add(
                    new TransactionDTOResponse(
                            amount, balance, blockchainTransactionHash,
                            commission, currency, id, paymentMethod,
                            status, timestamp, type));
        });
        return new TransactionsResponse(transactionDTOResponses);
    }
}
