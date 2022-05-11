package by.mrf1n.finance.currencycom.webclient.context;


import by.mrf1n.finance.currencycom.CurrencyComOpenApiConfig;
import by.mrf1n.finance.currencycom.property.CurrencyComAdapterProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;

import java.math.BigInteger;
import java.net.URI;
import java.util.Date;

public abstract class BaseContextImpl {

  protected String authKey;
  protected String authSecret;
  protected BigInteger recvWindow;
  protected WebClient client;
  protected ObjectMapper mapper;

  public BaseContextImpl(String authKey, String authSecret) {
    this.authKey = authKey;
    this.authSecret = authSecret;
    this.mapper = new ObjectMapper();
  }

  protected UriBuilder buildWithTime(UriBuilder uriBuilder, String path, BigInteger customTime) {
    BigInteger timestamp = customTime != null
            ? customTime
            : BigInteger.valueOf(new Date().getTime());
    return uriBuilder
            .path(path)
            .queryParam("timestamp", timestamp);
  }

  protected String encodeHmacSha256(String data) {
    return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, this.authSecret).hmacHex(data);
  }

  protected URI createURIWithSignature(URI uriWithoutSignature) {
    return new DefaultUriBuilderFactory().uriString(uriWithoutSignature.toString())
            .queryParam("signature", this.encodeHmacSha256(uriWithoutSignature.getQuery()))
            .build();
  }

  @Autowired
  public void setRecvWindow(BigInteger recvWindow) {
    this.recvWindow = recvWindow;
  }
}
