package com.fizzer.doraemon.android_fizzer_utils.Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fizzer.doraemon.android_fizzer_utils.R;

/**
 * 加载圈
 * Created by Fizzer on 2016/10/14.
 * Email: doraemonmqq@sina.com
 */

public class LoadingDialog extends LinearLayout {

    private ImageView ivLoading;


    public LoadingDialog(Context context) {
        super(context);
        init(context);
    }

    public LoadingDialog(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LoadingDialog(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View loadingView = View.inflate(context, R.layout.loading_layout, null);
        ivLoading = (ImageView) loadingView.findViewById(R.id.ivLoading);
//        setLoadingAnimation();
        setScaleAnimation();
        this.addView(loadingView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    private void setLoadingAnimation() {

        final RotateAnimation AnimRotateLoading = new RotateAnimation(0, 359, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        AnimRotateLoading.setInterpolator(new LinearInterpolator());
        AnimRotateLoading.setRepeatCount(99);// 重复次数
        AnimRotateLoading.setDuration(1000);
        AnimRotateLoading.setAnimationListener(null);

        AnimRotateLoading.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ivLoading.startAnimation(AnimRotateLoading);
            }
        });

        ivLoading.startAnimation(AnimRotateLoading);
    }

    /**
     * 设置缩放动画
     */
    private void setScaleAnimation(){
        final ScaleAnimation animation1 = new ScaleAnimation(1.0f,1.3f,1.0f,1.3f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation1.setDuration(2000);
        ivLoading.startAnimation(animation1);

        final ScaleAnimation animation2 = new ScaleAnimation(1.3f,1.0f,1.3f,1.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation2.setDuration(2000);

        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ivLoading.startAnimation(animation2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ivLoading.startAnimation(animation1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
