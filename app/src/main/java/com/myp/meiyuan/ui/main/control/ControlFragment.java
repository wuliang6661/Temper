package com.myp.meiyuan.ui.main.control;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
import com.myp.meiyuan.entity.FamenBo;
import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.mvp.MVPBaseFragment;
import com.myp.meiyuan.ui.controlmessage.ControlMessageActivity;
import com.myp.meiyuan.ui.deviceadd.DeviceAddActivity;
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

public class ControlFragment extends MVPBaseFragment<ControlContract.View, ControlPresenter> implements ControlContract.View, View.OnClickListener {


    @Bind(R.id.add_devices)
    TextView addDevices;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.recycle)
    RecyclerView recycle;

    List<GroupBO> jianceGroups;

    int position;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_control, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(manager);

        jianceGroups = new ArrayList<>();
        addDevices.setOnClickListener(this);
        title.setText("控制设备");
        mPresenter.getTab();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                mPresenter.getFamenList(jianceGroups.get(tab.getPosition()).getGroupId() + "");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if(!jianceGroups.isEmpty()){
            mPresenter.getFamenList(jianceGroups.get(position).getGroupId() + "");
        }
    }

    /**
     * 设置数据
     */
    private void setAdapter(final List<FamenBo> list) {
        LGRecycleViewAdapter<FamenBo> adapter = new LGRecycleViewAdapter<FamenBo>(list) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_control;
            }

            @Override
            public void convert(LGViewHolder holder, FamenBo s, int position) {
                ImageView deviceImg = (ImageView) holder.getView(R.id.device_img);
                TextView type = (TextView) holder.getView(R.id.connect_type_text);
                ImageView point = (ImageView) holder.getView(R.id.connect_type_point);
                TextView type_text = (TextView) holder.getView(R.id.type_text);
                holder.setText(R.id.device_id, "ID:" + s.getDeviceId());
                if (s.getEstate() == 1) {
                    type.setText("在线");
                    type.setTextColor(Color.parseColor("#49baff"));
                    type_text.setTextColor(Color.parseColor("#88ceff"));
                    point.setImageResource(R.drawable.point);
                } else {
                    type.setText("离线");
                    type.setTextColor(Color.parseColor("#999999"));
                    type_text.setTextColor(Color.parseColor("#999999"));
                    point.setImageResource(R.drawable.hui_point);
                }
                holder.setText(R.id.device_name, s.getDeviceName());
                holder.setText(R.id.type_text, s.getMode());
                switch (s.getDeviceTypeId()) {
                    case LocalConfiguration.DEVICE_TYPE_SWITCH:
                        if (s.getEstate() == 1) {
                            deviceImg.setImageResource(R.drawable.device_jichu);
                        } else {
                            deviceImg.setImageResource(R.drawable.device_jichu_hui);
                        }
                        break;
                    case LocalConfiguration.DEVICE_TYPE_MOSWITCH:
                        if (s.getEstate() == 1) {
                            deviceImg.setImageResource(R.drawable.device_moni);
                        } else {
                            deviceImg.setImageResource(R.drawable.device_moni_hui);
                        }
                        break;
                    case LocalConfiguration.DEVICE_TYPE_BUSWITCH:
                        if (s.getEstate() == 1) {
                            deviceImg.setImageResource(R.drawable.device_buguangdeng);
                        } else {
                            deviceImg.setImageResource(R.drawable.device_buguangdeng_hui);
                        }
                        break;
                }
            }
        };
        adapter.setOnItemClickListener(R.id.item_layout, new LGRecycleViewAdapter.ItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(getActivity(), ControlMessageActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("famenBo", list.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        recycle.setAdapter(adapter);
    }


    @Override
    public void onDestroyView() {
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

    @Override
    public void showFamenList(List<FamenBo> famenBos) {
        setAdapter(famenBos);
    }

    @Override
    public void getTab(List<GroupBO> groupBOs) {
        jianceGroups = new ArrayList<>();
        for (GroupBO groupBO : groupBOs) {
            if (groupBO.getGroupType() == 1) {
                jianceGroups.add(groupBO);
                tabLayout.addTab(tabLayout.newTab().setText(groupBO.getGroupName()));
            }
        }
        mPresenter.getFamenList(jianceGroups.get(0).getGroupId() + "");
    }
}
