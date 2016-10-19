package com.fizzer.doraemon.android_fizzer_utils.Activity;

import android.os.Bundle;

import com.fizzer.doraemon.android_fizzer_utils.R;
import com.fizzer.doraemon.android_fizzer_utils.Utils.CustomToast;
import com.fizzer.doraemon.android_fizzer_utils.Utils.DateUtils;
import com.fizzer.doraemon.android_fizzer_utils.Utils.Logger;

public class DateTransfromTest extends BaseActivity {

    private long time = 1476766800000l; //2016-9-18
    private long time1 = 1497967200000l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_date_transfrom_test_layout);

//        CustomToast.showToast(this, DateUtils.getFormatDate("1476766800000"),"");
        Logger.myLogger(DateUtils.getFriendlyDate(time));
        Logger.myLogger(DateUtils.getFriendlyDate(time1));
    }

}
