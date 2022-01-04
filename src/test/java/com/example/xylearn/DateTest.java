package com.example.xylearn;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class DateTest {
    @Test
    public void testLocateDate11(){

        Long a = 10000000000L;
        Long b = 10000000000L;
        System.out.println(a == b);
    }
    Logger logger = LoggerFactory.getLogger(DateTest.class);
    @Test
    public void testLocateDate(){

        LocalDate localDate = LocalDate.now();
        logger.info(localDate.toString());
        LocalDate localDate1 = LocalDate.of(999_999_999,2,12);
        logger.info(localDate1.toString());
        int a = 999_999_999;
        logger.info(a+"");
        //ChronoUnit

    }

    /**
     * of：静态工厂方法。
     * parse：静态工厂方法，关注于解析。
     * get：获取值。
     * is：用于比较。
     * with：不可变的setter等价物。
     * plus：加一些量到某个对象。
     * minus：从某个对象减去一些量。
     * to：转换到另一个类型。
     * at：把这个对象与另一个对象组合起来，例如：date.atTime(time)。
     *
     */
    @Test
    public void testLocateDate1(){
        //获取当前日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime :" + localDateTime);
        LocalDateTime localDateTime2 = localDateTime.minusDays(12);
        //格式化输出时间，线程安全的格式化类
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy哈哈哈哈MM月dd日 HH:mm:ss");
        System.out.println("format :" + dateTimeFormatter.format(localDateTime2));
        //  获取当前年份
        Year year = Year.of(2019);
        System.out.println("year :" + year);
        //   从Year获取LocalDate
        LocalDate localDate = year.atDay(41);
        System.out.println("localDate :" + localDate);
        //  把LocalTime关联到一个LocalDate得到一个LocalDateTime
        LocalTime localTime = LocalTime.of(13,0);
        LocalDateTime localDateTime1 = localTime.atDate(localDate);
        System.out.println("localDateTime1 :" + dateTimeFormatter.format(localDateTime1));
        //  判断是否是闰年
        System.out.println("isLeapYear :" + localDate.isLeapYear());
        LocalDate now = LocalDate.now();
        localDate.isAfter(now);
        LocalDate parse = LocalDate.parse("2020哈哈哈哈02月14日 12:04:55", dateTimeFormatter);
        System.out.println("parse :" + parse);
        LocalDateTime localDateTime3 = localDate.atStartOfDay();
    }

    /**
     * DateTimeFormatter：在日期对象与字符串之间进行转换。
     * ChronoUnit：计算出两个时间点之间的时间距离，可按多种时间单位计算。
     * TemporalAdjuster：各种日期计算功能。
     */
    @Test
    public void DateTimeAdjust() {
        LocalDate localDate = LocalDate.now();
        DayOfWeek dayOfWeek = DayOfWeek.of(1);
        System.out.println("dayOfWeek :" + dayOfWeek);
        //计算两个日期之间时间，还可以按其他时间单位计算两个时间点之间的间隔。
        long between = ChronoUnit.HOURS.between(LocalDateTime.of(2019,2,10,22,0), LocalDateTime.of(2019,2,9,22,0));
        System.out.println("between :" + between);
        //  解析字符串形式的日期时间
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy MM d");
        TemporalAccessor temporalAccessor = dateTimeFormatter2.parse("2019 01 31");
        System.out.println("temporalAccessor :" + LocalDate.from(temporalAccessor));
        //计算某月的第一天的日期
        LocalDate with =  localDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("with :" + with);
        // 计算某月的第一个星期一的日期
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY);
        LocalDate with1 = localDate.with(temporalAdjuster);
        System.out.println("with1 :" + with1);
        // 计算localDate的下一个星期一的日期
        LocalDate with2 = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("with2 :" + with2);
    }

    @Test
    public void DateTimeToDate() {
        LocalDate localDate = LocalDate.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);

        Date date = Date.from(zonedDateTime.toInstant());

        LocalDateTime localDateTime = date.toInstant().atZone(zoneId).toLocalDateTime().minusDays(-1);
        Date fin = Date.from(localDateTime.atZone( ZoneId.systemDefault()).toInstant());
    }



}
