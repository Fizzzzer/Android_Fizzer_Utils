package com.fizzer.doraemon.android_fizzer_utils.Activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.fizzer.doraemon.android_fizzer_utils.R;
import com.fizzer.doraemon.android_fizzer_utils.Services.MyServices;
import com.fizzer.doraemon.android_fizzer_utils.Utils.CustomDialog;
import com.fizzer.doraemon.android_fizzer_utils.Utils.CustomToast;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, MyServices.class));
    }

    public void customToast(View view) {
        CustomToast.showToast(this, "这里是标题", "这里是内容");
    }

    public void customDialog(View view) {
        final CustomDialog dialog = new CustomDialog(this);
        dialog.setTitleText("警告");
        dialog.setContentText("岩神是东湖眼子王,姐姐v是东湖挂机王");
        dialog.setLeftButtonOnClick(new CustomDialog.onLeftButtonClick() {
            @Override
            public void leftButtonClick() {
            }
        });

        dialog.setRightButtonOnClick(new CustomDialog.onRightButtonClick() {
            @Override
            public void rightButtonClick() {
                CustomToast.showToast(MainActivity.this, "姐姐v", "红岩天书");
            }
        });
        dialog.show();
    }

    public void loadingDialog(View view) {
        startActivity(new Intent(this, LoadingActivity.class));
    }

    public void dataTransform(View view) {
        startActivity(new Intent(this, DateTransfromTest.class));
    }

    public void toMarket(View view) {
//        Intent intent = new Intent();
//        intent.setAction("android.intent.action.MAIN");
//        intent.addCategory("android.intent.category.APP_MARKET");
//        PackageManager pm = this.getPackageManager();
//        List<ResolveInfo> infos = pm.queryIntentActivities(intent, 0);
//        int size = infos.size();
//        for (int i = 0; i < size; i++) {
//            ActivityInfo activityInfo = infos.get(i).activityInfo;
//            String packageName = activityInfo.packageName;
//            Logger.myLogger(packageName);
//        }

//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        Uri uri = Uri.parse("market://details?id=" + "com.renrui.job");
//        intent.setData(uri);
//        intent.setPackage("com.tencent.android.qqdownloader");
//        startActivity(intent);

//        Intent startintent = new Intent("android.intent.action.MAIN");
//        startintent.addCategory("android.intent.category.APP_MARKET");
//        startintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(startintent);

        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
//        getMarketList();
//        getAppList();
    }

    public void notification(View view) {

        final NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        long[] vir = {0, 100};
        final Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher).setContentTitle("标题").setContentText("内容")
                .setVibrate(vir).setDefaults(Notification.FLAG_AUTO_CANCEL);
        manager.notify(0, builder.build());
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i += 5) {
                    builder.setProgress(100, i, false);
                    builder.setContentText(i + "%");
                    manager.notify(0, builder.build());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                builder.setContentText("下载完成");

            }
        }).start();
    }

    public void scroolTextView(View view) {

        stopService(new Intent(this,MyServices.class));
    }




}
