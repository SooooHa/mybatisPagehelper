package cn.demo.config;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: 57251180@qq.com
 * Date: 1/8/2020
 */
public class DateUtils {
    // 日期转换时间
   public static String data2String(Date date,String patt){
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
       String format = simpleDateFormat.format(date);
       return format;
   }
    //字符串转换成日期
    public static Date string2Date(String str, String patt) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }
}
