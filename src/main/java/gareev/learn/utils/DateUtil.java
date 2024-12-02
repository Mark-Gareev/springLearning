package gareev.learn.utils;

import java.time.LocalDate;
import java.sql.Date;
import java.time.ZoneId;

public class DateUtil {
    public static LocalDate fromSqlDate(Date date) {
        return date.toLocalDate();
    }

    public static Date toSqlDate(LocalDate localDate) {
        return Date.valueOf(localDate);
    }
}
