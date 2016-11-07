package com.fizzer.doraemon.android_fizzer_utils.Utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.PowerManager;
import android.text.TextUtils;

/**
 * Created by Fizzer on 2016/11/7.
 * Email: doraemonmqq@sina.com
 */

public class ActiveUtils {

    /**
     * 判断当前应用是否处于活动状态
     * @param context
     * @return
     */
    public static boolean isRunningForeground(Context context) {

        //先判断是否锁屏
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = pm.isScreenOn();//如果为true，则表示屏幕“亮”了，否则屏幕“暗”了。
        if(!isScreenOn){
            return isScreenOn;
        }

        //判断是否处于活动状态
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
        String currentPackageName = cn.getPackageName();
        if (!TextUtils.isEmpty(currentPackageName) && currentPackageName.equals(context.getPackageName())) {
            return true;
        }

        return false;
    }
}
