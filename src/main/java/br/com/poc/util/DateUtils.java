package br.com.poc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getDateAndTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}
