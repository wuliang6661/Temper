package com.myp.meiyuan.ui.updatedivicename.updatename;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.entity.DeviceConGroup;
import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.ui.updategreenhouse.UpdateGreenHouseActivity;
import com.myp.meiyuan.util.LogUtils;
import com.myp.meiyuan.util.StringUtils;

import butterknife.Bind;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class UpdateNameActivity extends MVPBaseActivity<UpdateNameContract.View, UpdateNamePresenter>
        implements UpdateNameContract.View, View.OnClickListener {

    @Bind(R.id.add_devices)
    TextView addDevices;
    @Bind(R.id.edit_dapeng)
    EditText editDapeng;
    @Bind(R.id.item_layout)
    RelativeLayout itemLayout;
    @Bind(R.id.group_name)
    TextView groupName;


    GroupBO groupBO;
    DeviceConGroup device;

    @Override
    protected int getLayout() {
        return R.layout.act_update_devicename;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        goBack();
        setTitle("修改");
        addDevices.setText("完成");

        addDevices.setOnClickListener(this);
        itemLayout.setOnClickListener(this);

        device = (DeviceConGroup) getIntent().getExtras().getSerializable("device");
        groupName.setText(device.getGroupName());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_devices:
                String deviceName = editDapeng.getText().toString().trim();
                if (StringUtils.isEmpty(deviceName)) {
                    LogUtils.showToast("请输入设备名称！");
                    return;
                }
                if (groupBO == null) {
                    mPresenter.updateDeviceName(device.getDeviceId() + "", device.getDeviceTypeId() + "",
                            device.getGroupId() + "", deviceName);
                } else {
                    mPresenter.updateDeviceName(device.getDeviceId() + "", device.getDeviceTypeId() + "",
                            groupBO.getGroupId() + "", deviceName);
                }
                break;
            case R.id.item_layout:
                Intent intent = new Intent(this, UpdateGreenHouseActivity.class);
                intent.putExtra("isResult", true);
                startActivityForResult(intent, 0x11);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        switch (resultCode) {
            case 0x11:
                groupBO = (GroupBO) data.getSerializableExtra("groupBO");
                groupName.setText(groupBO.getGroupName());
                break;
        }
    }

    @Override
    public void onSuress() {
        finish();
    }
}
