package com.weather.redbee.utilities;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;

@Component
public class Utilities {

    public Timestamp getCurrentDateTime() {
        Calendar toDay = Calendar.getInstance();
        toDay.clear(Calendar.MILLISECOND);
        toDay.clear(Calendar.SECOND);
        return new Timestamp(toDay.getTimeInMillis());
    }

    public Timestamp getBeforesHourDateTime() {
        Calendar toDay = Calendar.getInstance();
        toDay.clear(Calendar.MILLISECOND);
        toDay.clear(Calendar.SECOND);
        toDay.add(Calendar.HOUR_OF_DAY, -1);

        return new Timestamp(toDay.getTimeInMillis());
    }

    public String getImgUrl(String description) {
        return StringUtils.substringBefore(
                StringUtils.substringAfter(
                        description,"=\""), "\"/>");
    }
}
