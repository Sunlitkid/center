package com.sunlitkid.center.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by sunke on 2017/8/1.
 */
public class DateUtil {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public  static String format(Date date){
        return  sdf.format(date).toString();
    }
}
