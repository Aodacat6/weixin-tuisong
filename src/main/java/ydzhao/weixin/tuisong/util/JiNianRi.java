package ydzhao.weixin.tuisong.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static ydzhao.weixin.tuisong.util.DateUtil.YYYYMMDD;

/**
 * @ClassName JiNianRi
 * @Description TODO
 * @Author ydzhao
 * @Date 2022/8/2 17:32
 */
public class JiNianRi {
    /**
     * 恋爱
     */
    static String lianAi = "2013-08-15";
    /**
     * 领证
     */
    public static String linZheng = "2022-08-15";
    /**
     * 结婚
     */
    static String jieHun = "2022-10-04";

    /**
     * 生日
     */
    public static String shengRi_ly = "11-10";

    public static String shengRi_dl = "12-27";

    /**
     * 距离date还有多少天
     * @param date
     * @return
     */
    public static int before(String date) {
        int day = 0;
        long time = DateUtil.str2Date(date, YYYYMMDD).getTime() - System.currentTimeMillis();
        day = (int) (time / 86400000L);
        return day;
    }


    /**
     * 已经过去date多少天
     * @param date
     * @return
     */
    public static int after(String date) {
        int day = 0;
        long time = System.currentTimeMillis() - DateUtil.str2Date(date, YYYYMMDD).getTime();
        day = (int) (time / 86400000L);
        return day;
    }

    public static int getJieHun() {
        return before(jieHun);
    }

    public static int getLinZhen() {
        return before(linZheng);
    }

    public static int getLianAi() {
        return after(lianAi);
    }


    public static void main(String[] args) {
        System.out.println(getJieHun());
    }

}
