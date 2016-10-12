package com.fizzer.doraemon.android_fizzer_utils.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fizzer.doraemon.android_fizzer_utils.R;
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

}
