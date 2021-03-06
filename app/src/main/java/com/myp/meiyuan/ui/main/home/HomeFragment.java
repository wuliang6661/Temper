package com.myp.meiyuan.ui.main.home;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.config.LocalConfiguration;
import com.myp.meiyuan.entity.DeviceBO;
import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.mvp.MVPBaseFragment;
import com.myp.meiyuan.ui.deviceadd.DeviceAddActivity;
import com.myp.meiyuan.ui.monitormessage.MonitorMessageActivity;
import com.myp.meiyuan.ui.videolist.VideoListActivity;
import com.myp.meiyuan.util.LogUtils;
import com.myp.meiyuan.util.TemperImgUtils;
import com.myp.meiyuan.widget.lgrecycleadapter.LGRecycleViewAdapter;
import com.myp.meiyuan.widget.lgrecycleadapter.LGViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class HomeFragment extends MVPBaseFragment<HomeContract.View, HomePresenter> implements HomeContract.View, View.OnClickListener {

    private static final long updateTime = 15000;   //每6秒更新一下数据


    @Bind(R.id.recycle)
    RecyclerView recycle;
    @Bind(R.id.add_devices)
    TextView addDevices;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;

    LGRecycleViewAdapter<DeviceBO> adapter;

    List<GroupBO> jianceGroups;
    String groupId;
    List<DeviceBO> deviceBOs;

    int position;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_home, null);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(manager);
        title.setText("监测设备");

        addDevices.setOnClickListener(this);
        handler.postDelayed(runnable, updateTime);
        showProgress("加载中...");
        mPresenter.getTab();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                recycle.setVisibility(View.GONE);
                showProgress("加载中...");
                mPresenter.getDeviceList(jianceGroups.get(tab.getPosition()).getGroupId() + "");
                groupId = jianceGroups.get(tab.getPosition()).getGroupId() + "";
                LogUtils.E("进来了！");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    /**
     * 设置数据
     */
    private void setAdapter() {
        if (adapter != null) {
            adapter.setDataList(deviceBOs);
            return;
        }
        adapter = new LGRecycleViewAdapter<DeviceBO>(deviceBOs) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_home;
            }

            @Override
            public void convert(LGViewHolder holder, DeviceBO s, int position) {
                TextView value = (TextView) holder.getView(R.id.value);
                holder.setText(R.id.device_id, "ID:" + s.getDeviceId());
                holder.setText(R.id.device_name, s.getDeviceName());
                holder.setText(R.id.device_time, s.getLastTime());
                value.setText(s.getValue());
                TextView type = (TextView) holder.getView(R.id.connect_type_text);
                ImageView point = (ImageView) holder.getView(R.id.connect_type_point);
                ImageView deviceImg = (ImageView) holder.getView(R.id.device_img);
                TextView valueType = (TextView) holder.getView(R.id.value_type);
                if (s.getEstate().equals("在线")) {
                    type.setText("在线");
                    type.setTextColor(Color.parseColor("#49baff"));
                    value.setTextColor(Color.parseColor("#2897ff"));
                    point.setImageResource(R.drawable.point);
                } else {
                    type.setText("离线");
                    type.setTextColor(Color.parseColor("#999999"));
                    value.setTextColor(Color.parseColor("#999999"));
                    point.setImageResource(R.drawable.hui_point);
                }
                deviceImg.setImageResource(TemperImgUtils.getResImg(s.getDeviceTypeId(), s.getEstate()));
                valueType.setText(TemperImgUtils.getTextType(s.getDeviceTypeId()));
            }
        };
        adapter.setOnItemClickListener(R.id.item_layout, new LGRecycleViewAdapter.ItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                if (deviceBOs.get(position).getDeviceTypeId() == LocalConfiguration.DEVICE_TYPE_VIDEO) {
                    Intent intent = new Intent(getActivity(), VideoListActivity.class);
                    intent.putExtra("groupId", groupId);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getActivity(), MonitorMessageActivity.class);
                    intent.putExtra("deviceBo", deviceBOs.get(position));
                    startActivity(intent);
                }
            }
        });
        recycle.setAdapter(adapter);
    }


    @Override
    public void onDestroyView() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_devices:
                Intent intent = new Intent(getActivity(), DeviceAddActivity.class);
                startActivity(intent);
                break;
        }
    }

    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (jianceGroups != null) {
                mPresenter.getDeviceList(jianceGroups.get(position).getGroupId() + "");
            }
            handler.postDelayed(this, updateTime);
        }
    };

    @Override
    public void getDeviceList(List<DeviceBO> deviceBOs, String groupId) {
        stopProgress();
        recycle.setVisibility(View.VISIBLE);
        if (jianceGroups.get(position).getGroupId() == Integer.parseInt(groupId)) {
            this.deviceBOs = deviceBOs;
            setAdapter();
        }
    }

    @Override
    public void getTab(List<GroupBO> groupBOs) {
        jianceGroups = new ArrayList<>();
        for (GroupBO groupBO : groupBOs) {
            if (groupBO.getGroupType() == 0) {
                jianceGroups.add(groupBO);
                tabLayout.addTab(tabLayout.newTab().setText(groupBO.getGroupName()));
            }
        }
//        mPresenter.getDeviceList(jianceGroups.get(0).getGroupId() + "");
//        groupId = jianceGroups.get(0).getGroupId() + "";
    }

    @Override
    public void getVideoNum(int size) {

    }
}
