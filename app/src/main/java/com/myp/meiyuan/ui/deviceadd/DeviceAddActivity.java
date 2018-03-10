package com.myp.meiyuan.ui.deviceadd;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.base.MyApplication;
import com.myp.meiyuan.config.LocalConfiguration;
import com.myp.meiyuan.entity.DeviceTypeBo;
import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.ui.updategreenhouse.UpdateGreenHouseActivity;
import com.myp.meiyuan.ui.updategreenhouse.update.UpdateActivity;
import com.myp.meiyuan.util.LogUtils;
import com.myp.meiyuan.util.StringUtils;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;


/**
 * 添加设备页面
 */

public class DeviceAddActivity extends MVPBaseActivity<DeviceAddContract.View, DeviceAddPresenter>
        implements DeviceAddContract.View, View.OnClickListener {


    @Bind(R.id.add_devices)
    TextView addDevices;
    @Bind(R.id.device_name)
    TextView deviceName;
    @Bind(R.id.device_name_layout)
    RelativeLayout deviceNameLayout;
    @Bind(R.id.device_id)
    TextView deviceId;
    @Bind(R.id.device_id_layout)
    RelativeLayout deviceIdLayout;
    @Bind(R.id.wangguan_name)
    TextView wangguanName;
    @Bind(R.id.wangguan_name_layout)
    RelativeLayout wangguanNameLayout;
    @Bind(R.id.wangguan_id)
    TextView wangguanId;
    @Bind(R.id.wangguan_id_layout)
    RelativeLayout wangguanIdLayout;
    @Bind(R.id.wangguan_bianma)
    TextView wangguanBianma;
    @Bind(R.id.wangguan_bianma_layout)
    RelativeLayout wangguanBianmaLayout;
    @Bind(R.id.address)
    TextView address;
    @Bind(R.id.address_layout)
    RelativeLayout addressLayout;
    @Bind(R.id.beizhu)
    TextView beizhu;
    @Bind(R.id.beizhu_layout)
    RelativeLayout beizhuLayout;
    @Bind(R.id.device_type)
    TextView deviceType;
    @Bind(R.id.device_type_layout)
    RelativeLayout deviceTypeLayout;
    @Bind(R.id.yujing)
    TextView yujing;
    @Bind(R.id.yujing_layout)
    RelativeLayout yujingLayout;
    @Bind(R.id.gaojing)
    TextView gaojing;
    @Bind(R.id.gaojing_layout)
    RelativeLayout gaojingLayout;
    @Bind(R.id.yuejie)
    TextView yuejie;
    @Bind(R.id.yuejie_layout)
    RelativeLayout yuejieLayout;
    @Bind(R.id.jierufangshi)
    TextView jierufangshi;
    @Bind(R.id.jierufangshi_layout)
    RelativeLayout jierufangshiLayout;
    @Bind(R.id.pingpai)
    TextView pingpai;
    @Bind(R.id.pingpai_layout)
    RelativeLayout pingpaiLayout;
    @Bind(R.id.xinghao)
    TextView xinghao;
    @Bind(R.id.xinghao_layout)
    RelativeLayout xinghaoLayout;
    @Bind(R.id.gujian_version)
    TextView gujianVersion;
    @Bind(R.id.gujian_versition_layout)
    RelativeLayout gujianVersitionLayout;
    @Bind(R.id.zhibo_address)
    TextView zhiboAddress;
    @Bind(R.id.zhibo_address_layout)
    RelativeLayout zhiboAddressLayout;
    @Bind(R.id.wifi_id)
    TextView wifiId;
    @Bind(R.id.wifi_id_layout)
    RelativeLayout wifiIdLayout;
    @Bind(R.id.zuzhi)
    TextView zuzhi;
    @Bind(R.id.zuzhi_layout)
    RelativeLayout zuzhiLayout;
    @Bind(R.id.quyu_text)
    TextView quyuText;
    @Bind(R.id.quyu_layout)
    RelativeLayout quyuLayout;
    @Bind(R.id.wangdian)
    TextView wangdian;
    @Bind(R.id.wangdian_layout)
    RelativeLayout wangdianLayout;
    @Bind(R.id.dapeng_name)
    TextView dapengName;
    @Bind(R.id.dapeng_name_layout)
    RelativeLayout dapengNameLayout;

    GroupBO groupBO;
    DeviceTypeBo typeBo;

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

        setListener();
    }


    private void setListener() {
        deviceNameLayout.setOnClickListener(this);
        deviceIdLayout.setOnClickListener(this);
        wangguanNameLayout.setOnClickListener(this);
        wangguanIdLayout.setOnClickListener(this);
        wangguanBianmaLayout.setOnClickListener(this);
        addressLayout.setOnClickListener(this);
        beizhuLayout.setOnClickListener(this);
        deviceTypeLayout.setOnClickListener(this);
        yujingLayout.setOnClickListener(this);
        gaojingLayout.setOnClickListener(this);
        yuejieLayout.setOnClickListener(this);
        jierufangshiLayout.setOnClickListener(this);
        pingpaiLayout.setOnClickListener(this);
        xinghaoLayout.setOnClickListener(this);
        zhiboAddressLayout.setOnClickListener(this);
        wifiIdLayout.setOnClickListener(this);
        zuzhiLayout.setOnClickListener(this);
        quyuLayout.setOnClickListener(this);
        wangdianLayout.setOnClickListener(this);
        gujianVersitionLayout.setOnClickListener(this);
        dapengNameLayout.setOnClickListener(this);
        addDevices.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, UpdateActivity.class);
        intent.putExtra("isUserMessage", true);
        switch (v.getId()) {
            case R.id.device_name_layout:
                startActivityForResult(intent, 0x11);
                break;
            case R.id.device_id_layout:
                intent.putExtra("isCode", true);
                startActivityForResult(intent, 0x22);
                break;
            case R.id.wangguan_name_layout:
                startActivityForResult(intent, 0x33);
                break;
            case R.id.wangguan_id_layout:
                intent.putExtra("isNum", true);
                startActivityForResult(intent, 0x44);
                break;
            case R.id.wangguan_bianma_layout:
                intent.putExtra("isCode", true);
                startActivityForResult(intent, 0x55);
                break;
            case R.id.address_layout:
                startActivityForResult(intent, 0x66);
                break;
            case R.id.beizhu_layout:
                startActivityForResult(intent, 0x77);
                break;
            case R.id.device_type_layout:
                Intent intent2 = new Intent(this, UpdateGreenHouseActivity.class);
                intent2.putExtra("isResult", true);
                intent2.putExtra("isType", true);
                startActivityForResult(intent2, 0x88);
                break;
            case R.id.yujing_layout:
                intent.putExtra("isNum", true);
                startActivityForResult(intent, 0x99);
                break;
            case R.id.gaojing_layout:
                intent.putExtra("isNum", true);
                startActivityForResult(intent, 0xa1);
                break;
            case R.id.yuejie_layout:
                intent.putExtra("isNum", true);
                startActivityForResult(intent, 0xa2);
                break;
            case R.id.jierufangshi_layout:
                startActivityForResult(intent, 0xA3);
                break;
            case R.id.pingpai_layout:
                startActivityForResult(intent, 0xA4);
                break;
            case R.id.xinghao_layout:
                startActivityForResult(intent, 0xA5);
                break;
            case R.id.gujian_versition_layout:
                startActivityForResult(intent, 0xA6);
                break;
            case R.id.zhibo_address_layout:
                startActivityForResult(intent, 0xA7);
                break;
            case R.id.wifi_id_layout:
                intent.putExtra("isNum", true);
                startActivityForResult(intent, 0xA8);
                break;
            case R.id.zuzhi_layout:
                startActivityForResult(intent, 0xA9);
                break;
            case R.id.quyu_layout:
                startActivityForResult(intent, 0xAA);
                break;
            case R.id.wangdian_layout:
                startActivityForResult(intent, 0xAB);
                break;
            case R.id.dapeng_name_layout:
                Intent intent1 = new Intent(this, UpdateGreenHouseActivity.class);
                intent1.putExtra("isResult", true);
                startActivityForResult(intent1, 0xBB);
                break;
            case R.id.add_devices:
                JSONObject object = getData();
                if (object != null) {
                    mPresenter.addDevices(object);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        switch (requestCode) {
            case 0x11:
                deviceName.setText(data.getStringExtra("data"));
                break;
            case 0x22:
                deviceId.setText(data.getStringExtra("data"));
                break;
            case 0x33:
                wangguanName.setText(data.getStringExtra("data"));
                break;
            case 0x44:
                wangguanId.setText(data.getStringExtra("data"));
                break;
            case 0x55:
                wangguanBianma.setText(data.getStringExtra("data"));
                break;
            case 0x66:
                address.setText(data.getStringExtra("data"));
                break;
            case 0x77:
                beizhu.setText(data.getStringExtra("data"));
                break;
            case 0x88:
                typeBo = (DeviceTypeBo) data.getSerializableExtra("typeBo");
                deviceType.setText(typeBo.getDeviceTypeName());
                break;
            case 0x99:
                yujing.setText(data.getStringExtra("data"));
                break;
            case 0xa1:
                gaojing.setText(data.getStringExtra("data"));
                break;
            case 0xa2:
                yuejie.setText(data.getStringExtra("data"));
                break;
            case 0xA3:
                jierufangshi.setText(data.getStringExtra("data"));
                break;
            case 0xA4:
                pingpai.setText(data.getStringExtra("data"));
                break;
            case 0xA5:
                xinghao.setText(data.getStringExtra("data"));
                break;
            case 0xA6:
                gujianVersion.setText(data.getStringExtra("data"));
                break;
            case 0xA7:
                zhiboAddress.setText(data.getStringExtra("data"));
                break;
            case 0xA8:
                wifiId.setText(data.getStringExtra("data"));
                break;
            case 0xA9:
                zuzhi.setText(data.getStringExtra("data"));
                break;
            case 0xAA:
                quyuText.setText(data.getStringExtra("data"));
                break;
            case 0xAB:
                wangdian.setText(data.getStringExtra("data"));
                break;
            case 0xBB:
                groupBO = (GroupBO) data.getSerializableExtra("groupBO");
                dapengName.setText(groupBO.getGroupName());
                break;
        }
    }

    /**
     * 获取添加设备信息
     */
    private JSONObject getData() {
        if (!isAddDevices()) {
            return null;
        }
        JSONObject object = new JSONObject();
        try {
            object.put("username", MyApplication.sp.getString(LocalConfiguration.userName));
            object.put("ename", deviceName.getText().toString().trim());
            object.put("eno", deviceId.getText().toString().trim());
            object.put("egroup", dapengName.getText().toString().trim());
            object.put("groupId", groupBO.getGroupId());
            object.put("eaddress", address.getText().toString().trim());
            object.put("yellow", yujing.getText().toString().trim());
            object.put("red", gaojing.getText().toString().trim());
            object.put("orange", yuejie.getText().toString().trim());
            object.put("etype", typeBo.getDeviceTypeId());
            object.put("gateway_id", wangguanId.getText().toString().trim());
            object.put("gateway_name", wangguanName.getText().toString().trim());
            object.put("gateway_code", wangguanBianma.getText().toString().trim());
            object.put("channel", wifiId.getText().toString().trim());
            object.put("access_mode", StringUtils.isEmpty(jierufangshi.getText().toString().trim()) ? 0 :
                    jierufangshi.getText().toString().trim());
            object.put("brand", pingpai.getText().toString().trim());
            object.put("model", xinghao.getText().toString().trim());
            object.put("firmware", gujianVersion.getText().toString().trim());
            object.put("organization", zuzhi.getText().toString().trim());
            object.put("region", quyuText.getText().toString().trim());
            object.put("branch", wangdian.getText().toString().trim());
            object.put("eremark", beizhu.getText().toString().trim());
            object.put("live_url", zhiboAddress.getText().toString().trim());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }


    private boolean isAddDevices() {
        if (StringUtils.isEmpty(deviceName.getText().toString().trim())) {
            LogUtils.showToast("请输入设备名称！");
            return false;
        }
        if (StringUtils.isEmpty(deviceId.getText().toString().trim())) {
            LogUtils.showToast("请输入设备ID！");
            return false;
        }
        if (StringUtils.isEmpty(deviceType.getText().toString().trim())) {
            LogUtils.showToast("请输入设备类型！");
            return false;
        }
        if (groupBO == null) {
            LogUtils.showToast("请输入大棚名称！");
            return false;
        }
        if (StringUtils.isEmpty(wifiId.getText().toString().trim())) {
            LogUtils.showToast("请输入无线Id值！");
            return false;
        }
        if (StringUtils.isEmpty(wangguanBianma.getText().toString().trim())) {
            LogUtils.showToast("请输入网关编码！");
            return false;
        }
        return true;
    }

    @Override
    public void onSuress() {
        LogUtils.showToast("添加成功！");
        finish();
    }
}
