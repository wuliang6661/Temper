package com.myp.meiyuan.ui.updatedivicename;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.entity.DeviceAndGroupBo;
import com.myp.meiyuan.entity.DeviceConGroup;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.ui.updatedivicename.updatename.UpdateNameActivity;
import com.myp.meiyuan.ui.updategreenhouse.update.UpdateActivity;
import com.myp.meiyuan.widget.lgrecycleadapter.LGRecycleViewAdapter;
import com.myp.meiyuan.widget.lgrecycleadapter.LGViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/**
 * 修改设备名称
 */

public class UpdateDiviceNameActivity extends MVPBaseActivity<UpdateDiviceNameContract.View, UpdateDiviceNamePresenter> implements UpdateDiviceNameContract.View {

    @Bind(R.id.add_devices)
    TextView addDevices;
    @Bind(R.id.recycle)
    RecyclerView recycle;

    List<DeviceConGroup> devices;

    @Override
    protected int getLayout() {
        return R.layout.act_recycleview;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        goBack();
        setTitle("修改设备名称");
        addDevices.setVisibility(View.GONE);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(manager);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getDeviceNameAndGroup("ganzhou");
    }

    private void setAdapter(List<DeviceConGroup> list) {
        LGRecycleViewAdapter<DeviceConGroup> adapter = new LGRecycleViewAdapter<DeviceConGroup>(list) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_device_name;
            }

            @Override
            public void convert(LGViewHolder holder, DeviceConGroup s, int position) {
                holder.setText(R.id.device_name, s.getDeviceName());
                holder.setText(R.id.group_name, "（" + s.getGroupName() + "）");
            }
        };
        adapter.setOnItemClickListener(R.id.item_layout, new LGRecycleViewAdapter.ItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("device", devices.get(position));
                gotoActivity(UpdateNameActivity.class, bundle, false);
            }
        });
        recycle.setAdapter(adapter);
    }

    @Override
    public void getDeviceName(List<DeviceAndGroupBo> deviceAndGroupBos) {
        devices = new ArrayList<>();
        for (DeviceAndGroupBo device : deviceAndGroupBos) {
            for (DeviceAndGroupBo.DevicesBean devicesBean : device.getDevices()) {
                DeviceConGroup dev = new DeviceConGroup();
                dev.setGroupId(device.getGroupId());
                dev.setGroupName(device.getGroupName());
                dev.setDeviceId(devicesBean.getDeviceId());
                dev.setDeviceName(devicesBean.getDeviceName());
                dev.setDeviceTypeId(devicesBean.getDeviceTypeId());
                devices.add(dev);
            }
        }
        setAdapter(devices);
    }


}
