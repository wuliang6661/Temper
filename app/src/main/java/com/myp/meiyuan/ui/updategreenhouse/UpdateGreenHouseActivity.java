package com.myp.meiyuan.ui.updategreenhouse;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.entity.DeviceTypeBo;
import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.ui.updategreenhouse.update.UpdateActivity;
import com.myp.meiyuan.widget.lgrecycleadapter.LGRecycleViewAdapter;
import com.myp.meiyuan.widget.lgrecycleadapter.LGViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/**
 * 修改大鹏名称
 */

public class UpdateGreenHouseActivity extends MVPBaseActivity<UpdateGreenHouseContract.View, UpdateGreenHousePresenter>
        implements UpdateGreenHouseContract.View {

    @Bind(R.id.add_devices)
    TextView addDevices;
    @Bind(R.id.recycle)
    RecyclerView recycle;

    boolean isResult = false;
    boolean isType = false;

    String[] names;
    List<DeviceTypeBo> deviceTypeBos;

    @Override
    protected int getLayout() {
        return R.layout.act_update_green;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goBack();
        addDevices.setVisibility(View.GONE);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(manager);

        isResult = getIntent().getBooleanExtra("isResult", false);
        isType = getIntent().getBooleanExtra("isType", false);
        if (isResult) {
            setTitle("大棚名称");
        } else {
            setTitle("修改大棚名称");
        }
        if (isType) {
            setTitle("设备类型");
            getData();
        }
    }


    /**
     * 创建设备类型集合
     */
    private void getData() {
        names = new String[]{"空气温度", "空气湿度", "CO2浓度", "光照强度",
                "视频", "开关", "图片", "土壤养分", "土壤水分",
                "土壤养分和水分", "土壤温度", "土壤PH", "三通道土壤水分",
                "风速，风向，雨量", "模拟水阀", "补光灯"};
        deviceTypeBos = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            DeviceTypeBo typeBo = new DeviceTypeBo();
            typeBo.setDeviceTypeName(names[i]);
            typeBo.setDeviceTypeId(i + 1);
            deviceTypeBos.add(typeBo);
        }
        setTypeAdapter();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (!isType) {
            mPresenter.getGroupList();
        }
    }

    /**
     * 设置适配器
     */
    private void setAdapter(final List<GroupBO> groupBOs) {
        LGRecycleViewAdapter<GroupBO> adapter = new LGRecycleViewAdapter<GroupBO>(groupBOs) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_green_hourse;
            }

            @Override
            public void convert(LGViewHolder holder, GroupBO groupBO, int position) {
                holder.setText(R.id.group_name, groupBO.getGroupName());
            }
        };
        adapter.setOnItemClickListener(R.id.item_layout, new LGRecycleViewAdapter.ItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                if (isResult) {
                    Intent intent = new Intent();
                    intent.putExtra("groupBO", groupBOs.get(position));
                    setResult(0x11, intent);
                    finish();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("groupBO", groupBOs.get(position));
                    gotoActivity(UpdateActivity.class, bundle, false);
                }
            }
        });
        recycle.setAdapter(adapter);
    }


    /**
     * 设置设备类型adapter
     */
    private void setTypeAdapter() {
        LGRecycleViewAdapter<DeviceTypeBo> adapter = new LGRecycleViewAdapter<DeviceTypeBo>(deviceTypeBos) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_green_hourse;
            }

            @Override
            public void convert(LGViewHolder holder, DeviceTypeBo groupBO, int position) {
                holder.setText(R.id.group_name, groupBO.getDeviceTypeName());
            }
        };
        adapter.setOnItemClickListener(R.id.item_layout, new LGRecycleViewAdapter.ItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                if (isResult) {
                    Intent intent = new Intent();
                    intent.putExtra("typeBo", deviceTypeBos.get(position));
                    setResult(0x11, intent);
                    finish();
                }
            }
        });
        recycle.setAdapter(adapter);
    }


    @Override
    public void showGroupList(List<GroupBO> groupBOs) {
        setAdapter(groupBOs);
    }
}
