package com.fizzer.doraemon.android_fizzer_utils.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.fizzer.doraemon.android_fizzer_utils.R;
import com.fizzer.doraemon.android_fizzer_utils.Utils.LoadingDialog;

/**
 * Created by Fizzer on 2016/10/14.
 * Email: doraemonmqq@sina.com
 */

public class BaseActivity extends Activity{
    private LoadingDialog mLoadingView;
    private FrameLayout mContent;
    public TextView mPageTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_base_layout);

        mLoadingView = (LoadingDialog) findViewById(R.id.loadingView);
        mContent = (FrameLayout) findViewById(R.id.content);
        mPageTitle = (TextView) findViewById(R.id.PageTitle);

        View contentView = View.inflate(this,layoutResID,null);
        mContent.addView(contentView);
    }

    /**
     * 设置加载时界面
     */
    public void setLoadingView(){
        mContent.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
    }

    /**
     * 设置加载成功界面
     */
    public void setLoadingSueecss(){
        mContent.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
    }
}
