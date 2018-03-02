package com.myp.meiyuan.ui.controlmessage;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mylhyl.circledialog.CircleDialog;
import com.myp.meiyuan.R;
import com.myp.meiyuan.config.LocalConfiguration;
import com.myp.meiyuan.entity.FamenBo;
import com.myp.meiyuan.entity.FamenTimeBo;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.util.LogUtils;
import com.myp.meiyuan.util.StringUtils;
import com.myp.meiyuan.util.TimeUtils;
import com.myp.meiyuan.widget.EasyPickView;
import com.myp.meiyuan.widget.lgrecycleadapter.LGRecycleViewAdapter;
import com.myp.meiyuan.widget.lgrecycleadapter.LGViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/**
 * 控制详情
 */

public class ControlMessageActivity extends MVPBaseActivity<ControlMessageContract.View, ControlMessagePresenter>
        implements ControlMessageContract.View, View.OnClickListener {

    @Bind(R.id.add_devices)
    TextView addDevices;
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
    @Bind(R.id.mode_text)
    TextView modeText;
    @Bind(R.id.mode_selecte)
    RelativeLayout modeSelecte;
    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.easy_pickview)
    EasyPickView easyPickview;
    @Bind(R.id.recycle)
    RecyclerView recycle;
    @Bind(R.id.add_time_img)
    ImageButton addTimeImg;
    @Bind(R.id.add_time_text)
    TextView addTimeText;
    @Bind(R.id.add_time)
    LinearLayout addTime;
    @Bind(R.id.famenkaidu)
    LinearLayout famenkaidu;
    @Bind(R.id.famen_checked)
    RelativeLayout famenChecked;
    @Bind(R.id.famen_text)
    TextView famenText;
    @Bind(R.id.famen_checkbox)
    CheckBox famenCheckbox;
    @Bind(R.id.dingshi_text)
    TextView dingshiText;
    @Bind(R.id.dingshi_checkbox)
    CheckBox dingshiCheckbox;
    @Bind(R.id.famenkaidu_text)
    TextView famenkaiduText;

    FamenBo famenBo;
    List<FamenTimeBo> famenTimeBos;
    LGRecycleViewAdapter<FamenTimeBo> adapter;


    @Override
    protected int getLayout() {
        return R.layout.act_control_message;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goBack();


        famenTimeBos = new ArrayList<>();
        addDevices.setText("完成");
        modeSelecte.setOnClickListener(this);
        addTime.setOnClickListener(this);
        addDevices.setOnClickListener(this);
        invition();
        inviData();
        recycle.setNestedScrollingEnabled(false);
    }


    /**
     * 初始化控件
     */
    private void invition() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(manager);
        Bundle bundle = getIntent().getExtras();
        famenBo = (FamenBo) bundle.getSerializable("famenBo");
        setTitle(famenBo.getDeviceName());
        deviceName.setText(famenBo.getDeviceName());
        deviceId.setText("ID:" + famenBo.getDeviceId());
        deviceTime.setText(famenBo.getLastStatusChangeTime());
        value.setVisibility(View.GONE);
        valueType.setVisibility(View.GONE);
        switch (famenBo.getDeviceTypeId()) {
            case LocalConfiguration.DEVICE_TYPE_BUSWITCH:  //补光灯
                // TODO: 2018/3/1  在线离线字段需要更改
                if (famenBo.getDeviceName().equals("在线")) {
                    deviceImg.setImageResource(R.drawable.device_buguangdeng);
                } else {
                    deviceImg.setImageResource(R.drawable.device_buguangdeng_hui);
                }
                break;
            case LocalConfiguration.DEVICE_TYPE_MOSWITCH:  //模拟水阀
                famenkaidu.setVisibility(View.VISIBLE);
                famenChecked.setVisibility(View.GONE);
                if (famenBo.getDeviceName().equals("在线")) {
                    deviceImg.setImageResource(R.drawable.device_moni);
                } else {
                    deviceImg.setImageResource(R.drawable.device_moni_hui);
                }
                break;
            case LocalConfiguration.DEVICE_TYPE_SWITCH:   //基础水阀
                famenkaidu.setVisibility(View.GONE);
                famenChecked.setVisibility(View.VISIBLE);
                if (famenBo.getDeviceName().equals("在线")) {
                    deviceImg.setImageResource(R.drawable.device_jichu);
                } else {
                    deviceImg.setImageResource(R.drawable.device_jichu_hui);
                }
                break;
        }
        if (famenBo.getDeviceName().equals("在线")) {
            connectTypePoint.setImageResource(R.drawable.point);
            connectTypeText.setText("在线");
            connectTypeText.setTextColor(Color.parseColor("#49baff"));
        } else {
            connectTypePoint.setImageResource(R.drawable.hui_point);
            connectTypeText.setText("离线");
            connectTypeText.setTextColor(Color.parseColor("#999999"));
        }
        modeText.setText(famenBo.getMode());
        if ("自动".equals(famenBo.getMode())) {
            swithMode(1);
        } else {
            swithMode(0);
        }
        famenCheckbox.setChecked(famenBo.getEstate() == 1);
        dingshiCheckbox.setChecked("1".equals(famenBo.getTimeStatus()));
        setDingshiAdapter();
    }

    /**
     * 设置定时数据
     */
    private void setDingshiAdapter() {
        String[] times = famenBo.getTimeParameters().split("\\|");
        for (String str : times) {
            String[] items = str.split("-");
            FamenTimeBo timeBo = new FamenTimeBo();
            if (items.length >= 3) {
                timeBo.setKaidu(items[2]);
            }
            if (items.length >= 2) {
                timeBo.setEndTime(items[1]);
            }
            if (items.length >= 1) {
                timeBo.setStartTime(items[0]);
            }
            famenTimeBos.add(timeBo);
        }
        setTimeAdapter();
    }


    /**
     * 设置阀门开度数据
     */
    private void inviData() {
        List<String> hour = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            hour.add(i + "%");
        }
        easyPickview.setDataList(hour);
        easyPickview.moveTo(Integer.parseInt(famenBo.getFirstLetter()) - 1);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mode_selecte:
                final ModeDialogFragment dialogFragment = new ModeDialogFragment();
                dialogFragment.setOnConmitListener(new ModeDialogFragment.OnConmitListener() {
                    @Override
                    public void commit(String value) {
                        dialogFragment.dismissAllowingStateLoss();
                        modeText.setText(value);
                        if ("自动".equals(value)) {
                            swithMode(1);
                        } else {
                            swithMode(0);
                        }
                    }
                });
                dialogFragment.show(getSupportFragmentManager(), "");
                break;
            case R.id.add_time:
                if (famenBo.getDeviceTypeId() == LocalConfiguration.DEVICE_TYPE_MOSWITCH) {
                    final SimulateDialogFragment simulateDialogFragment = new SimulateDialogFragment();
                    simulateDialogFragment.setOnCommitListener(new SimulateDialogFragment.onCommitListener() {
                        @Override
                        public void commit(String startTime, String endTime, String kaidu) {
                            simulateDialogFragment.dismissAllowingStateLoss();
                            FamenTimeBo famenTimeBo = new FamenTimeBo();
                            famenTimeBo.setStartTime(startTime);
                            famenTimeBo.setEndTime(endTime);
                            famenTimeBo.setKaidu(kaidu.replaceAll("%",""));
                            famenTimeBos.add(famenTimeBo);
                            setTimeAdapter();
                        }
                    });
                    simulateDialogFragment.show(getSupportFragmentManager(), "");
                } else if (famenBo.getDeviceTypeId() == LocalConfiguration.DEVICE_TYPE_SWITCH) {
                    final BasicsDialogFragment simulateDialogFragment = new BasicsDialogFragment();
                    simulateDialogFragment.setOnCommitListener(new BasicsDialogFragment.onCommitListener() {
                        @Override
                        public void commit(String startTime, String endTime) {
                            simulateDialogFragment.dismissAllowingStateLoss();
                            FamenTimeBo famenTimeBo = new FamenTimeBo();
                            famenTimeBo.setStartTime(startTime);
                            famenTimeBo.setEndTime(endTime);
                            famenTimeBos.add(famenTimeBo);
                            setTimeAdapter();
                        }
                    });
                    simulateDialogFragment.show(getSupportFragmentManager(), "");
                }
                break;
            case R.id.add_devices:
                String timeStatus;
                String estate;
                if (dingshiCheckbox.isChecked()) {
                    timeStatus = "1";
                } else {
                    timeStatus = "0";
                }
                if (famenCheckbox.isChecked()) {
                    estate = "1";
                } else {
                    estate = "0";
                }
                switch (famenBo.getDeviceTypeId()) {
                    case LocalConfiguration.DEVICE_TYPE_MOSWITCH:
                        LogUtils.E(getTimePartarms());
                        mPresenter.updateControl(famenBo.getDeviceTypeId() + "", famenBo.getDeviceId() + "", null,
                                TimeUtils.millis2String(System.currentTimeMillis()), modeText.getText().toString(), getTimePartarms(), timeStatus,
                                easyPickview.getValue().replaceAll("%", ""));
                        break;
                    case LocalConfiguration.DEVICE_TYPE_SWITCH:
                        mPresenter.updateControl(famenBo.getDeviceTypeId() + "", famenBo.getDeviceId() + "", estate,
                                TimeUtils.millis2String(System.currentTimeMillis()), modeText.getText().toString(),
                                getTimePartarms(), timeStatus, easyPickview.getValue().replace("%", ""));
                        break;
                }
                break;
        }
    }


    /**
     * 获取所有的定时
     */
    private String getTimePartarms() {
        StringBuilder builder = new StringBuilder();
        for (FamenTimeBo famenTimeBo : famenTimeBos) {
            if (StringUtils.isEmpty(famenTimeBo.getKaidu())) {
                builder.append(famenTimeBo.getStartTime() + "-" + famenTimeBo.getEndTime() + "|");
            } else {
                builder.append(famenTimeBo.getStartTime() + "-" + famenTimeBo.getEndTime() + "-" + famenTimeBo.getKaidu() + "|");
            }
        }
        if (StringUtils.isEmpty(builder)) {
            return "";
        }
        return builder.toString().substring(0, builder.length() - 1);
    }


    /**
     * 切换自动还是手动
     * <p>
     * status 0 : 为自动 1为手动
     */
    private void swithMode(int status) {
        if (status == 1) {
            famenText.setTextColor(Color.parseColor("#cccccc"));
            dingshiText.setTextColor(Color.parseColor("#cccccc"));
            addTimeText.setTextColor(Color.parseColor("#cccccc"));
            famenkaiduText.setTextColor(Color.parseColor("#cccccc"));
            easyPickview.setEnabled(false);
            addTime.setEnabled(false);
            addTimeImg.setEnabled(false);
            famenCheckbox.setEnabled(false);
            dingshiCheckbox.setEnabled(false);
        } else {
            famenText.setTextColor(Color.parseColor("#333333"));
            dingshiText.setTextColor(Color.parseColor("#333333"));
            addTimeText.setTextColor(Color.parseColor("#333333"));
            famenkaiduText.setTextColor(Color.parseColor("#333333"));
            easyPickview.setEnabled(true);
            addTime.setEnabled(true);
            famenCheckbox.setEnabled(true);
            dingshiCheckbox.setEnabled(true);
            addTimeImg.setEnabled(true);
        }
        setTimeAdapter();
    }

    /**
     * 增加定时器
     */
    private void setTimeAdapter() {
        adapter = new LGRecycleViewAdapter<FamenTimeBo>(famenTimeBos) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_dingshi_time;
            }

            @Override
            public void convert(LGViewHolder holder, FamenTimeBo famenTimeBo, int position) {
                CheckBox checkBox = (CheckBox) holder.getView(R.id.item_dingshi_check);
                TextView time = (TextView) holder.getView(R.id.time);
                TextView item_kaidu = (TextView) holder.getView(R.id.item_kaidu);
                TextView time_id = (TextView) holder.getView(R.id.time_id);
                if ("自动".equals(modeText.getText().toString())) {
                    time.setTextColor(Color.parseColor("#cccccc"));
                    item_kaidu.setTextColor(Color.parseColor("#cccccc"));
                    time_id.setTextColor(Color.parseColor("#cccccc"));
                    checkBox.setEnabled(false);
                } else {
                    time.setTextColor(Color.parseColor("#333333"));
                    item_kaidu.setTextColor(Color.parseColor("#333333"));
                    time_id.setTextColor(Color.parseColor("#333333"));
                    checkBox.setEnabled(true);
                }
                time.setText(famenTimeBo.getStartTime() + "~" + famenTimeBo.getEndTime());
                if (StringUtils.isEmpty(famenTimeBo.getKaidu())) {
                    item_kaidu.setVisibility(View.GONE);
                } else {
                    item_kaidu.setVisibility(View.VISIBLE);
                    item_kaidu.setText("开度" + famenTimeBo.getKaidu() + "%");
                }
                checkBox.setChecked(famenTimeBo.isChecked());
                time_id.setText("定时" + (position + 1));
                RelativeLayout layout = (RelativeLayout) holder.getView(R.id.item_layout);
                layout.setTag(position);
                layout.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(final View mview) {
                        new CircleDialog.Builder(ControlMessageActivity.this)
                                .setTitle("提示")
                                .setText("是否删除此条？")
                                .setTextColor(Color.parseColor("#333333"))
                                .setPositive("确定", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        int position = (int) mview.getTag();
                                        famenTimeBos.remove(position);
                                        adapter.setDataList(famenTimeBos);
                                    }
                                })
                                .setNegative("取消", null)
                                .show();
                        return true;
                    }
                });
            }
        };
        recycle.setAdapter(adapter);
    }

    @Override
    public void sunress() {
        finish();
    }
}
