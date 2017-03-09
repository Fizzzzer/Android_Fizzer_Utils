package com.fizzer.doraemon.android_fizzer_utils.Utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 截取屏幕的工具类
 * @author xiaolei.li
 */

public class ScreenShotUtils {

    /**
     * 进行截取屏幕
     *
     * @param activity
     * @return bitmap
     */
    public static Bitmap takeScreenShot(Activity activity) {
        // View是你须要截图的View
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();
        try {
            // 获取状况栏高度
            Rect frame = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
            int statusBarHeight = frame.top;

            // 获取屏幕长和高
            int width = activity.getWindowManager().getDefaultDisplay().getWidth();
            int height = activity.getWindowManager().getDefaultDisplay()
                    .getHeight();

            // 去掉题目栏
            Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height
                    - statusBarHeight);
            view.destroyDrawingCache();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            view.destroyDrawingCache();
            return b1;
        }
    }

    /**
     * 保存图片到sdcard中
     *
     * @param pBitmap
     */
    public static boolean savePic(Activity pActivity, Bitmap pBitmap, Runnable runnable) {
        try {

            String local_file = pActivity.getCacheDir().getPath() + "/cache/";

            File f = new File(local_file);
            if (!f.exists()) {
                f.mkdirs();
            }
            String local_file1 = f.getAbsolutePath() + "/" + "screen.png";
            File mFile = new File(local_file1);
            if (!mFile.createNewFile()) {
            }
            FileOutputStream fos = new FileOutputStream(mFile);
            if (null != fos) {
                pBitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
                fos.flush();
                fos.close();
                if (runnable != null) {
                    runnable.run();
                }
                return true;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 截图
     *
     * @param pActivity
     * @param runnable
     * @return 截图并且保存sdcard成功返回true，否则返回false
     */
    public static boolean saveBitmap(Activity pActivity, Runnable runnable) {
        return ScreenShotUtils.savePic(pActivity, takeScreenShot(pActivity), runnable);
    }


    /***
     * 获取截图
     *
     * @return
     */
    public static Bitmap returnBitmap(Activity pActivity) {
        if (Environment.getExternalStorageDirectory() == null) {
            return null;
        }
        try {
            String local_file = pActivity.getCacheDir().getPath() + "/cache/";
            File f = new File(local_file);
            if (!f.exists()) {
                f.mkdirs();
            }
            String local_file1 = f.getAbsolutePath() + "/" + "screen.png";
            File mFile = new File(local_file1);
            FileInputStream fis = new FileInputStream(mFile);
            if (null != fis) {
                Bitmap bitmap = BitmapFactory.decodeStream(fis);
                return bitmap;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /***
     * 获取文件
     *
     * @return
     */
    public static File returnFile(Activity pActivity) {
        if (Environment.getExternalStorageDirectory() == null) {
            return null;
        }
        String local_file = pActivity.getCacheDir().getPath() + "/cache/";
        File f = new File(local_file);
        if (!f.exists()) {
            f.mkdirs();
        }
        String local_file1 = f.getAbsolutePath() + "/" + "screen.png";
        File mFile = new File(local_file1);
        return mFile;

    }
}