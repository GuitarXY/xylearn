package com.example.dateutil;

import com.example.dateutil.base.BaseGeneralResult;
import com.example.dateutil.base.DateGeneralResult;
import com.example.dateutil.base.GeneralAnalyser;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiaoy
 * @date 2021/12/17
 *  2013-01-19
 *  2013年01月19日
 *  2013年1月1日
 *  2013/1/1
 */
public class NormalDateGeneralAnalyser extends BaseGeneralAnalyser<LocalDate, DateGeneralResult> {

    private static final Pattern DATE_EXTRACT = Pattern.compile(".*(\\d{4})\\s{0,4}[\\-/年]\\s{0,4}(\\d{1,2})\\s{0,4}[\\-/月]\\s{0,4}(\\d{1,2})[日]?.*");
    @Override
    protected BaseGeneralResult transfer(LocalDate results) {
        DateGeneralResult dateGeneralResult = new DateGeneralResult();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = results.atStartOfDay(zoneId);
        Date date = Date.from(zonedDateTime.toInstant());
        dateGeneralResult.setElement(date);

        return dateGeneralResult;
    }

    @Override
    protected LocalDate parsePatterResults(String val) {
        Matcher matcher = DATE_EXTRACT.matcher(val);
        if (matcher.matches()) {
            String year = matcher.group(1);
            String month = matcher.group(2);
            String day = matcher.group(3);
            return LocalDate.of(Integer.parseInt(year, 10),
                    Integer.parseInt(month, 10),
                    Integer.parseInt(day, 10));
        }

        throw  new RuntimeException("must sth wrong(date format) " + val);
    }
}
