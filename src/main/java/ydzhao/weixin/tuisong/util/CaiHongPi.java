package ydzhao.weixin.tuisong.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ydzhao.weixin.tuisong.constant.CommonConstant.tianxing_key;
import static ydzhao.weixin.tuisong.constant.CommonConstant.tianxing_url;

/**
 * @ClassName CaiHongPi
 * @Description TODO
 * @Author ydzhao
 * @Date 2022/8/2 17:26
 */
public class CaiHongPi {

    private static List<String> jinJuList = new ArrayList<>();
    private static String name = "媛媛";

    public static String getCaiHongPi() {
        //默认彩虹屁
        String str = "阳光落在屋里，爱你藏在心里";
        try {
            JSONObject jsonObject = JSONObject.parseObject(HttpUtil.getUrl(tianxing_url + tianxing_key));
            if (jsonObject.getIntValue("code") == 200) {
                str = jsonObject.getJSONArray("newslist").getJSONObject(0).getString("content");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str.contains("XXX")) {
            return str.replace("XXX", name);
        } else {
            return name + "，" + str;
        }
    }

    /**
     * 载入金句库
     */
    static {
        InputStream inputStream = CaiHongPi.class.getClassLoader().getResourceAsStream("jinju.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String str = "";
            String temp = "";
            while ((temp = br.readLine()) != null) {
                if (!StringUtils.isEmpty(temp)) {
                    str = str + "\r\n" + temp;
                } else {
                    jinJuList.add(str);
                    str = "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJinJu() {
        Random random = new Random();
        return jinJuList.get(random.nextInt(jinJuList.size()));
    }

    public static void main(String[] args) {
        //System.out.println(getJinJu());
        String str = "嗨嗨嗨";
        if (str.contains("XXX")) {
            System.out.println(str.replace("XXX", name));
        } else {
            System.out.println(name + "，" + str);
        }
    }
}
