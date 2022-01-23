package by.mrf1n.finance.currencycom.model;

import by.mrf1n.finance.currencycom.model.enums.AssetType;
import by.mrf1n.finance.currencycom.model.enums.MarkerMode;
import by.mrf1n.finance.currencycom.model.enums.MarketType;
import by.mrf1n.finance.currencycom.model.enums.OrderType;
import by.mrf1n.finance.currencycom.model.enums.SymbolStatus;
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
public class ExchangeSymbolInfo implements Serializable {

  private AssetType assetType;
  private String baseAsset;
  private Integer baseAssetPrecision;
  private String country;
  private Double exchangeFee;
  private List<SymbolFilter> filters;
  private String industry;
  private Double longRate;
  private Double makeFee;
  private List<MarkerMode> markerModes;
  private MarketType marketType;
  private Double maxSLGap;
  private Double maxTPGap;
  private Double minSLGap;
  private Double minTPGap;
  private String name;
  private List<OrderType> orderTypes;
  private String quoteAsset;
  private String quoteAssetId;
  private Integer quotePrecision;
  private String sector;
  private Double shortRate;
  private SymbolStatus status;
  private Double takerFee;
  private Double tickSize;
  private Double tickValue;
  private Double tradingFee;
  private String tradingHours;

}
