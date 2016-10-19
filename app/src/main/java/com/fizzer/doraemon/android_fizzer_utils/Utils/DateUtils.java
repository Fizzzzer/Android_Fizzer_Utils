package com.fizzer.doraemon.android_fizzer_utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 *
 * Date日期工具类
 * Created by Fizzer on 2016/10/18.
 * Email: doraemonmqq@sina.com
 */

public class DateUtils {

    private static SimpleDateFormat formatter;

    public static String getFormatDate(long date){
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }

    /**
     * 获取 yy-MM-dd格式的日期formatter
     * @return  formatter
     */
    public static SimpleDateFormat getSdf1(){
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter;
    }

    /**
     * 获取HH:mm:ss格式日期的formatter
     * @return  formatter
     */
    public static SimpleDateFormat getSdf2(){
        formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter;
    }

    /**
     * 得到时间的友好显示
     * 比如显示昨天,今天,明天
     * @param date  毫秒值时间
     * @return  时间
     */
    public static String getFriendlyDate(long date){

        String result = "";
        Calendar calNow = Calendar.getInstance();

        Calendar calTmp = Calendar.getInstance();
        calTmp.setTime(new Date(date));
        int thisYear = calNow.get(Calendar.YEAR);   //当前年
        int thisMonth = calNow.get(Calendar.MONTH);     //当前月
        int thisDay = calNow.get(Calendar.DAY_OF_MONTH);       //当前日

        int tmpYear = calTmp.get(Calendar.YEAR);
        int tmpMonth = calTmp.get(Calendar.MONTH);
        int tmpDay = calTmp.get(Calendar.DAY_OF_MONTH);

        if(thisYear == tmpYear && thisMonth == tmpMonth && thisDay == tmpDay){
            result = "今天" + getSdf2().format(date);
        }else if(thisYear == tmpYear && thisMonth == tmpMonth && (thisDay - tmpDay == 1)){
            result = "昨天" + getSdf2().format(date);
        }else if(thisYear == tmpYear && thisMonth == tmpMonth && (tmpDay - thisDay) == 1){
            result = "明天" + getSdf2().format(date);
        }else{
            result = getSdf1().format(date);
        }

        Logger.myLogger("this year:" + thisYear + "this month:" + thisMonth + "this Day:" + thisDay);
        Logger.myLogger("tmp year:" + tmpYear + "tmp month:" + tmpMonth + "tmp Day:" + tmpDay);

        return result;
    }

}
