package by.mrf1n.finance.bank.alfabankby.model;

import io.netty.util.internal.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class NationalRateListRequest implements Serializable {

    private Date date;
    private List<Integer> currencyCode;

    public String getDateByAlfaFormat() {
        return date != null
                ? new SimpleDateFormat("dd.MM.yyyy").format(date)
                : null;
    }

    public String getCodesSeparatedByComma() {
        return currencyCode.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

}
