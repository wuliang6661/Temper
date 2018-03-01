package com.myp.meiyuan.ui.deviceadd;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.mvp.MVPBaseActivity;

import butterknife.Bind;


/**
 * 添加设备页面
 */

public class DeviceAddActivity extends MVPBaseActivity<DeviceAddContract.View, DeviceAddPresenter> implements DeviceAddContract.View {


    @Bind(R.id.add_devices)
    TextView addDevices;

    @Override
    protected int getLayout() {
        return R.layout.act_device_add;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("添加设备");
        goBack();
        addDevices.setText("完成");

    }
}
