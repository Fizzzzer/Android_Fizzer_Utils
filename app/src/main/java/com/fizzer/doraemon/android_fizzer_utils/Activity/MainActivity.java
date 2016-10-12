package com.fizzer.doraemon.android_fizzer_utils.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fizzer.doraemon.android_fizzer_utils.R;
import com.fizzer.doraemon.android_fizzer_utils.Utils.CustomDialog;
import com.fizzer.doraemon.android_fizzer_utils.Utils.CustomToast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void customToast(View view){
        CustomToast.showToast(this,"这里是标题","这里是内容");
    }

    public void customDialog(View view){
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
                CustomToast.showToast(MainActivity.this,"姐姐v","红岩天书");
            }
        });
        dialog.show();
    }

}
