package com.example.dateutil;

import com.example.dateutil.base.BaseGeneralResult;
import com.example.dateutil.base.DateGeneralResult;
import com.example.dateutil.base.GeneralAnalyser;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xiaoy
 * @date 2021/12/17
 */
public class DateAnalyseTest {
    public static void main(String[] args) {
        String input = "2013年01月19日";//one date
        //remove \n \f \t...


        List<BaseGeneralResult> list = new ArrayList<>();

        List<GeneralAnalyser> dateAnalysers = DateAnalyserFactory.newAnalyser();
        GeneralAnalyserChain chain =GeneralAnalyserChain.newInstance(dateAnalysers);
        chain.doAnalyse(input,list,chain);


        for (BaseGeneralResult baseGeneralResult : list) {
            Date element = (Date) baseGeneralResult.getElement();
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime localDateTime = element.toInstant().atZone(zoneId).toLocalDateTime();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy哈哈哈哈MM月dd日 HH:mm:ss");
            System.out.println("format :" + dateTimeFormatter.format(localDateTime));
        }

    }
}
