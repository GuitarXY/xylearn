package com.example.dateutil;

import com.example.dateutil.base.GeneralAnalyser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoy
 * @date 2021/12/17
 */
public class DateAnalyserFactory {
    private static List<GeneralAnalyser> DEFAULT_ANALYSER = new ArrayList<>();
    static {
        DEFAULT_ANALYSER.add(new NormalDateGeneralAnalyser());
//        DEFAULT_ANALYSER.add(new GeneralAnalyserLocalDateRange());
//        DEFAULT_ANALYSER.add(new GeneralAnalyserLocalDateTime());
//        DEFAULT_ANALYSER.add(new GeneralAnalyserLocalDateTimePair());
//        DEFAULT_ANALYSER.add(new GeneralAnalyserMonthDay());
//        DEFAULT_ANALYSER.add(new GeneralAnalyserMonthDayRange());
//
//        DEFAULT_ANALYSER.add(new GeneralAnalyserWeekNo());
//        DEFAULT_ANALYSER.add(new GeneralAnalyserEveryDay());
//
//        DEFAULT_ANALYSER.add(new GeneralAnalyserHourMinute());
//        DEFAULT_ANALYSER.add(new GeneralAnalyserHourMinuteRange());
//
//        // TODO LOCATION
//        DEFAULT_ANALYSER.add(new GeneralAnalyserClassCount());
//        DEFAULT_ANALYSER.add(new GeneralAnalyserSubject());
//
//        DEFAULT_ANALYSER.add(new GeneralAnalyserTeacher());
    }

    public static List<GeneralAnalyser> newAnalyser(){
        return new ArrayList<>(DEFAULT_ANALYSER);
    }
}
