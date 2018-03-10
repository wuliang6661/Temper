package com.myp.meiyuan.ui.monitormessage;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.entity.DeviceBO;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.ui.FragmentPaerAdapter;
import com.myp.meiyuan.ui.monitormessage.chart.ChartFragment;
import com.myp.meiyuan.ui.monitormessage.message.MessageFragment;
import com.myp.meiyuan.util.TemperImgUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/**
 * 监测详情页面
 */

public class MonitorMessageActivity extends MVPBaseActivity<MonitorMessageContract.View, MonitorMessagePresenter>
        implements MonitorMessageContract.View {

    @Bind(R.id.device_img)
    ImageView deviceImg;
    @Bind(R.id.connect_type_point)
    ImageView connectTypePoint;
    @Bind(R.id.connect_type_text)
    TextView connectTypeText;
    @Bind(R.id.device_id)
    TextView deviceId;
    @Bind(R.id.device_name)
    TextView deviceName;
    @Bind(R.id.device_time)
    TextView deviceTime;
    @Bind(R.id.value)
    TextView value;
    @Bind(R.id.value_type)
    TextView valueType;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.view_pager)
    ViewPager viewPager;


    DeviceBO deviceBO;
    MessageFragment messageFragment;
    ChartFragment chartFragment;


    @Override
    protected int getLayout() {
        return R.layout.act_monitor_message;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        goBack();


        deviceBO = (DeviceBO) getIntent().getSerializableExtra("deviceBo");
        setTitle(deviceBO.getDeviceName());
        initView(deviceBO);
        messageFragment = MessageFragment.newInstance(deviceBO);
        chartFragment = ChartFragment.newInstance(deviceBO);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(chartFragment);
        fragments.add(messageFragment);
        viewPager.setAdapter(new FragmentPaerAdapter(getSupportFragmentManager(), fragments));
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * 初始化界面数据
     */
    private void initView(DeviceBO s) {
        deviceId.setText("ID:" + s.getDeviceId());
        deviceName.setText(s.getDeviceName());
        deviceTime.setText(s.getLastTime());
        if (s.getEstate().equals("在线")) {
            connectTypeText.setText("在线");
            connectTypeText.setTextColor(Color.parseColor("#49baff"));
            value.setTextColor(Color.parseColor("#2897ff"));
            connectTypePoint.setImageResource(R.drawable.point);
        } else {
            connectTypeText.setText("离线");
            connectTypeText.setTextColor(Color.parseColor("#999999"));
            value.setTextColor(Color.parseColor("#999999"));
            connectTypePoint.setImageResource(R.drawable.hui_point);
        }
        value.setText(s.getValue());
        deviceImg.setImageResource(TemperImgUtils.getResImg(s.getDeviceTypeId(),s.getEstate()));
        valueType.setText(TemperImgUtils.getTextType(s.getDeviceTypeId()));
    }
}
