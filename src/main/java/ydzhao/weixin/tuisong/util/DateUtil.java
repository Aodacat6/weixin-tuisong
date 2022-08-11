package ydzhao.weixin.tuisong.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：songdalin
 * @date ：2022/8/5 下午 6:06
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class DateUtil {

    public static final String YYYYMMDD = "yyyy-MM-dd";

    public static final String MMDD = "MM-dd";

    public static Date str2Date(String s, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String date2Str(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

}
