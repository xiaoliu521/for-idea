package org.example.utils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/**
 * 日期工具类 —— 学习java8 新日期类
 * 解决了Date类的大部分痛点
 * 1. 非线程安全
 * 2. 失去处理麻烦
 * 3. 各种格式化和时间计算繁琐
 * 4. 设计缺陷，Date类同时包含日期和时间；
 * 还有一个java.sql.Date，容易混淆
 *
 * 新日期类
 * 1. LocalTime： 表示时间 时分秒
 * 2. LocalDate： 表示日期 年月日
 * 3. LocalDateTime： 表示日期和时间
 * 4. ZonedDateTime：表示带时区的日期和时间
 * 5. Duration：表示时间段 （以秒和纳秒为单位）
 * 6. Period: 表示日期段
 * 7. Instant: 表示时间点 (以Unix时间戳为基础)
 */
public class DateUtils {


    public static void main(String[] args) {
        // 创建LocalDate实例
        LocalDate date = LocalDate.of(2025, 1, 11);
        System.out.println("日期: " + date);

        // 获取当前日期
        LocalDate today = LocalDate.now();
        System.out.println(today);

        // 日期操作
        LocalDate tomorrow = today.plusDays(1);
        System.out.println("明天: " + tomorrow);
        LocalDate nextMonth = today.plusMonths(1);
        System.out.println("下一个月"+  nextMonth);
        LocalDate lastYear = today.minusYears(1);
        System.out.println("去年: " + lastYear);

        // 日期比较
        System.out.println("明天在今天之后：" + tomorrow.isAfter(today));
        System.out.println(tomorrow.atStartOfDay());
        LocalDate localDate = tomorrow.withYear(2026);
        System.out.println(localDate);

        LocalTime now = LocalTime.now();
        System.out.println(now);
        LocalTime localTime = now.plusHours(-1);
        System.out.println(localTime);
        LocalTime lastMinute = now.minusMinutes(20);
        System.out.println(lastMinute);
        Duration between = Duration.between(now, lastMinute);
        System.out.println(between.getSeconds());
        Period between1 = Period.between(today, tomorrow);
        between1.getDays();


    }
}
