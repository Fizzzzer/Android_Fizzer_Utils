package com.fizzer.doraemon.android_fizzer_utils.Utils;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.fizzer.doraemon.android_fizzer_utils.R;

/**
 * Created by Fizzer on 2016/10/12.
 * Email: doraemonmqq@sina.com
 */

public class CustomDialog {
    private Context mContext;
    private Dialog mDialog;
    private TextView tvTitle;
    private TextView tvContent;
    private TextView tvLeftText;
    private TextView tvRightText;

    public CustomDialog(Context context) {
        mContext = context;
        mDialog = new Dialog(context, R.style.PageDialogStyle);
        mDialog.setContentView(R.layout.view_custom_dialog_layout);

        initView();
    }

    private void initView() {
        tvTitle = (TextView) mDialog.findViewById(R.id.tvTitle);
        tvContent = (TextView) mDialog.findViewById(R.id.tvContent);
        tvLeftText = (TextView) mDialog.findViewById(R.id.tvLeftText);
        tvRightText = (TextView) mDialog.findViewById(R.id.tvRightText);
    }

    /**
     * 设置提示标题
     *
     * @param content content
     */
    public void setTitleText(String content) {
        if (TextUtils.isEmpty(content)) {
            tvTitle.setText("标题");
        } else {
            tvTitle.setText(content);
        }
    }

    /**
     * 设置提示内容
     *
     * @param content content
     */
    public void setContentText(String content) {
        if (TextUtils.isEmpty(content)) {
            tvContent.setText("内容");
        } else {
            tvContent.setText(content);
        }
    }

    /**
     * 设置左边按钮的文字信息
     * @param content   content
     */
    public void setLeftButtonText(String content) {
        if (TextUtils.isEmpty(content)) {
            tvLeftText.setText("取消");
        } else {
            tvLeftText.setText(content);
        }
    }

    /**
     * 设置右边按钮的文字信息
     * @param content   content
     */
    public void setRightButtonText(String content) {
        if (TextUtils.isEmpty(content)) {
            tvRightText.setText("确定");
        } else {
            tvRightText.setText(content);
        }
    }

    /**
     * 显示dialog
     */
    public void show() {
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);   //设置dialog的显示动画
            mDialog.show();
        }
    }

    /**
     * 隐藏dialog
     */
    public void dismiss() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    /**
     * 设置左边按钮的点击事件
     *
     * @param onLeftButtonClick onLeftButtonClick
     */
    public void setLeftButtonOnClick(final onLeftButtonClick onLeftButtonClick) {

        tvLeftText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
                onLeftButtonClick.leftButtonClick();
            }
        });
    }

    /**
     * 设置右边按钮的点击事件
     *
     * @param onRightButtonClick onRightButtonClick
     */
    public void setRightButtonOnClick(final onRightButtonClick onRightButtonClick) {
        tvRightText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
                onRightButtonClick.rightButtonClick();
            }
        });
    }

    public interface onLeftButtonClick {
        public void leftButtonClick();
    }

    public interface onRightButtonClick {
        public void rightButtonClick();
    }
}
