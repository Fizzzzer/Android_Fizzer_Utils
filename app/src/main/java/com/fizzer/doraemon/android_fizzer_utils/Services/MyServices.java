package com.fizzer.doraemon.android_fizzer_utils.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.fizzer.doraemon.android_fizzer_utils.Utils.ActiveUtils;
import com.fizzer.doraemon.android_fizzer_utils.Utils.Logger;

/**
 * Created by Fizzer on 2016/11/7.
 * Email: doraemonmqq@sina.com
 */

public class MyServices extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        init();

    }

    public void init() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Logger.myLogger("应用是否在活动状态" + ActiveUtils.isRunningForeground(getApplicationContext()));
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
