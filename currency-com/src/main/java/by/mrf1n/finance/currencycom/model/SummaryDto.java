package by.mrf1n.finance.currencycom.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class SummaryDto implements Serializable {

    private String msg;
    private Map<String, SummaryData> data;
}
