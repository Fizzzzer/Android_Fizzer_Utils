package com.fizzer.doraemon.android_fizzer_utils.Utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fizzer.doraemon.android_fizzer_utils.R;

/**
 * Created by Fizzer on 2016/10/12.
 * Email: doraemonmqq@sina.com
 */

public class CustomToast {

    private static Toast myToast;
    private static TextView tvTitle;
    private static TextView tvContent;
    private static View viewMyToast;

    private static Toast getMyToast(Context mContext, String title, String content) {
        if (myToast == null) {
            myToast = new Toast(mContext);
            viewMyToast = View.inflate(mContext, R.layout.view_mytoast, null);
            tvTitle = (TextView) viewMyToast.findViewById(R.id.tvTitle);
            tvContent = (TextView) viewMyToast.findViewById(R.id.tvContent);
        }

        //设置title文字
        if (TextUtils.isEmpty(title)) {
            if (tvTitle.getVisibility() == View.VISIBLE) {
                tvTitle.setVisibility(View.GONE);
            }
        } else {
            if (tvTitle.getVisibility() == View.GONE) {
                tvTitle.setVisibility(View.VISIBLE);
            }
            tvTitle.setText(title);
        }

        //设置content文字
        if (TextUtils.isEmpty(content)) {
            if (tvContent.getVisibility() == View.VISIBLE) {
                tvContent.setVisibility(View.GONE);
            }
        } else {
            if (tvContent.getVisibility() == View.GONE) {
                tvContent.setVisibility(View.VISIBLE);
            }
            tvContent.setText(content);
        }
        myToast.setView(viewMyToast);

        return myToast;
    }

    /**
     * 显示自定义的Toast
     * @param context
     *          context
     * @param title
     *          title
     * @param content
     *          content
     */
    public static void showToast(Context context,String title,String content){
        myToast = getMyToast(context,title,content);
        myToast.setDuration(Toast.LENGTH_SHORT);
        myToast.setGravity(Gravity.CENTER,0,0); //设置Toast在界面的显示位置,这里显示在中间
        myToast.show();
    }
}
