package com.belatrix.jobLogger.util;

import java.text.DateFormat;
import java.util.Date;

public class DateUtil {

    public String formatDate(Date date, int format) {
        return DateFormat.getDateInstance(format).format(date);
    }
}
