package com.juggle.im.shadow.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String formatTime(long time){
        Date date = new Date(time);
        return formatter.format(date);
    }
}
