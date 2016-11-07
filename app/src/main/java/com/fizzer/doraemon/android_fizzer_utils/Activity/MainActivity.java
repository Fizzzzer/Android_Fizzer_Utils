package com.fizzer.doraemon.android_fizzer_utils.Activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.fizzer.doraemon.android_fizzer_utils.R;
import com.fizzer.doraemon.android_fizzer_utils.Services.MyServices;
import com.fizzer.doraemon.android_fizzer_utils.Utils.ActiveUtils;
import com.fizzer.doraemon.android_fizzer_utils.Utils.CustomDialog;
import com.fizzer.doraemon.android_fizzer_utils.Utils.CustomToast;
import com.fizzer.doraemon.android_fizzer_utils.Utils.Logger;

import java.util.ArrayList;
import java.util.List;

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
//        PendingIntent pi = PendingIntent.getActivities(this,0, new Intent[]{new Intent(this, MainActivity.class)},0);
//
//        Notification.Builder notification = new Notification.Builder(this).setSmallIcon(R.mipmap.ic_launcher);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, LoadingActivity.class), 0);
//
        Notification notify = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher) // 设置状态栏中的小图片，尺寸一般建议在24×24， 这里也可以设置大图标
                .setTicker("有新短消息了！")// 设置显示的提示文字
                .setContentTitle("标题")// 设置显示的标题
                .setContentText("消息的内容")// 消息的详细内容
                .setContentIntent(pendingIntent) // 关联PendingIntent
                .setNumber(5) // 在TextView的右方显示的数字，可以在外部定义一个变量，点击累加setNumber(count),这时显示的和
                .getNotification(); // 需要注意build()是在API level16及之后增加的，在API11中可以使用getNotificatin()来代替
        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, notify);

//        final NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        long[] vir = {0, 100};
//        final Notification.Builder builder = new Notification.Builder(this);
//        builder.setSmallIcon(R.mipmap.ic_launcher).setContentTitle("标题").setContentText("内容")
//                .setFullScreenIntent(pendingIntent, false).setContentIntent(pendingIntent).setVibrate(vir)
//                .setDefaults(Notification.FLAG_AUTO_CANCEL);
//        manager.notify(0, builder.build());
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <= 100; i += 5) {
//                    builder.setProgress(100, i, false);
//                    builder.setContentText(i + "%");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                builder.setContentText("下载完成");
//
//            }
//        }).start();
    }


    public void getMarketList() {
        Intent intent = new Intent();
        intent.setData(Uri.parse("market://details?id=android.browser"));
        List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);

        for (ResolveInfo info : list) {
            Logger.myLogger(info.resolvePackageName);
        }
    }

    public void getAppList() {
        PackageManager pm = this.getPackageManager();
        // Return a List of all packages that are installed on the device.
        List<PackageInfo> packages = pm.getInstalledPackages(0);

        List<String> packageName = new ArrayList<>();

        for (PackageInfo packageInfo : packages) {
            // 判断系统/非系统应用
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) { // 非系统应用
                packageName.add(packageInfo.packageName);
            }
        }

        for (String name : packageName) {
            Logger.myLogger(name);
        }
    }

    public void scroolTextView(View view) {

        stopService(new Intent(this,MyServices.class));
    }




}
