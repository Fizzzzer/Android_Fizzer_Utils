package com.fizzer.doraemon.android_fizzer_utils.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fizzer.doraemon.android_fizzer_utils.R;
import com.fizzer.doraemon.android_fizzer_utils.Widget.AutoHorizontalScrollTextView;
import com.fizzer.doraemon.android_fizzer_utils.Widget.AutoVerticalScrollTextView;

import java.util.Arrays;
import java.util.List;

public class ViewScroolTest extends AppCompatActivity {

    private String[] strings={"我的剑，就是你的剑!","俺也是从石头里蹦出来得!","我用双手成就你的梦想!","人在塔在!","犯我德邦者，虽远必诛!","我会让你看看什么叫残忍!","我的大刀早已饥渴难耐了!"};
    //    private String[] strings={"我的剑，就是你的剑!"};
    private String string="我的剑，就是你的剑!   俺也是从石头里蹦出来得!    我用双手成就你的梦想!    人在塔在!    犯我德邦者，虽远必诛!    我会让你看看什么叫残忍!    我的大刀早已饥渴难耐了!";

    private AutoVerticalScrollTextView verticalScrollTV;
    private AutoHorizontalScrollTextView horizontalScrollTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scrool_test);
        initView();
    }

    private void initView() {

        horizontalScrollTV = (AutoHorizontalScrollTextView) findViewById(R.id.textview);
        horizontalScrollTV.setText(string);

        verticalScrollTV = (AutoVerticalScrollTextView) findViewById(R.id.textview_auto_roll);


        verticalScrollTV.setData(Arrays.asList(strings));
        verticalScrollTV.setCusOnClcikListener(new AutoVerticalScrollTextView.OnClickListener() {
            @Override
            public void OnClick(int position, List<String> list) {
                Toast.makeText(ViewScroolTest.this,list.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        verticalScrollTV.setBackgroundColor(Color.parseColor("#A0ff0000"));

        horizontalScrollTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verticalScrollTV.stop();
            }
        });
    }

    @Override
    protected void onDestroy() {
        verticalScrollTV.stop();
        super.onDestroy();
    }
}
