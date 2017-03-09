package com.fizzer.doraemon.android_fizzer_utils.Utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Fizzer on 16/9/9.
 * Email: doraemonmqq@sina.com
 */
public class KeyboardUtils {

    private static InputMethodManager imm;

    private static InputMethodManager getInstance(Context context){
        if(null == imm){
            imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        }
        return imm;
    }


    /**
     * 显示键盘
     * @param context context
     * @param view view
     */
    public static void showSoftinput(Context context,View view){
        getInstance(context).showSoftInput(view,InputMethodManager.SHOW_FORCED);

    }

    /**
     * 关闭键盘
     * @param context context
     * @param view view
     */
    public static void hideSoftinput(Context context,View view){
        getInstance(context).hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}
