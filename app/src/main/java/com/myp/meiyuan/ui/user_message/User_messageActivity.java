package com.myp.meiyuan.ui.user_message;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.mvp.MVPBaseActivity;

import butterknife.Bind;


/**
 * 用户信息
 */

public class User_messageActivity extends MVPBaseActivity<User_messageContract.View, User_messagePresenter> implements User_messageContract.View {

    @Bind(R.id.add_devices)
    TextView addDevices;

    @Override
    protected int getLayout() {
        return R.layout.act_user_message;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        goBack();
        setTitle("个人信息");
        addDevices.setText("完成");


    }
}
