package by.mrf1n.finance.currencycom.webclient.context;


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

  public BaseContextImpl(String authKey, String authSecret) {
    this.authKey = authKey;
    this.authSecret = authSecret;
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

  protected URI createUriWithSignature(URI uriWithoutSignature) {
    return new DefaultUriBuilderFactory().uriString(uriWithoutSignature.toString())
            .queryParam("signature", this.encodeHmacSha256(uriWithoutSignature.getQuery()))
            .build();
  }

  protected URI createRawUriWithSignature(URI uriWithoutSignature) {
    DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory();
    factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
    return factory.uriString(uriWithoutSignature.toString())
            .queryParam("signature", this.encodeHmacSha256(uriWithoutSignature.getRawQuery()))
            .build();
  }

  protected UriBuilder disableEncoding(UriBuilder uriBuilder) {
    DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory();
    factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
    return factory.uriString(uriBuilder.build().toString());
  }

  @Autowired
  public void setRecvWindow(BigInteger recvWindow) {
    this.recvWindow = recvWindow;
  }
}
