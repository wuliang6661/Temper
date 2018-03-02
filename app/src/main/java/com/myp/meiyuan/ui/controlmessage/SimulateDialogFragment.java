package com.myp.meiyuan.ui.controlmessage;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.myp.meiyuan.R;
import com.myp.meiyuan.util.LogUtils;
import com.myp.meiyuan.widget.EasyPickView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuliang on 2018/2/28.
 * <p>
 * 模拟水阀选择定时器
 */

public class SimulateDialogFragment extends DialogFragment {


    private EasyPickView startTimeHour;
    private EasyPickView endTimeHour;
    private EasyPickView startTimeMintue;
    private EasyPickView endTimeMintue;
    private EasyPickView kaidu;
    private Button commit;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_simulate, container, false);
        //设置窗口以对话框样式显示
//		setStyle(DialogFragment.STYLE_NO_TITLE, R.style.dialog);
        //设置对话框背景色，否则有虚框
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置对话框弹出动画，从底部滑入，从底部滑出
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        getDialog().setCancelable(true);
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().getWindow().setGravity(Gravity.BOTTOM);

        initView(view);
        setData();
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = Gravity.BOTTOM;
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(attributes);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(startTimeHour.getValue()) > Integer.parseInt(endTimeHour.getValue())) {
                    LogUtils.showToast("开始时间必须小于结束时间！");
                    return;
                }
                if (Integer.parseInt(startTimeHour.getValue()) == Integer.parseInt(endTimeHour.getValue())) {
                    if (Integer.parseInt(startTimeMintue.getValue()) >= Integer.parseInt(endTimeMintue.getValue()))
                    {
                        LogUtils.showToast("开始时间必须小于结束时间！");
                        return;
                    }
                }

                if (listener != null) {
                    listener.commit(startTimeHour.getValue() + ":" + startTimeMintue.getValue(), endTimeHour.getValue() + ":" + endTimeMintue.getValue(), kaidu.getValue());
                }
            }
        });
    }

    /**
     * 初始化控件
     */
    private void initView(View view) {
        startTimeHour = (EasyPickView) view.findViewById(R.id.start_time_hour);
        startTimeMintue = (EasyPickView) view.findViewById(R.id.start_time_minute);
        endTimeHour = (EasyPickView) view.findViewById(R.id.end_time_hour);
        endTimeMintue = (EasyPickView) view.findViewById(R.id.end_time_minute);
        kaidu = (EasyPickView) view.findViewById(R.id.kaidu);
        commit = (Button) view.findViewById(R.id.commit);
    }


    /**
     * 设置数据
     */
    private void setData() {
        startTimeHour.setDataList(getHourList());
        endTimeHour.setDataList(getHourList());
        startTimeMintue.setDataList(getMinteList());
        endTimeMintue.setDataList(getMinteList());
        kaidu.setDataList(getKaiduList());
    }


    /**
     * 获取小时列表
     */
    private List<String> getHourList() {
        List<String> hour = new ArrayList<>();
        for (int i = 1; i <= 24; i++) {
            if (i < 10) {
                hour.add("0" + i);
            } else {
                hour.add(i + "");
            }
        }
        return hour;
    }


    /**
     * 获取分钟列表
     */
    private List<String> getMinteList() {
        List<String> hour = new ArrayList<>();
        for (int i = 0; i <= 60; i++) {
            if (i < 10) {
                hour.add("0" + i);
            } else {
                hour.add(i + "");
            }
        }
        return hour;
    }


    /**
     * 获取开度列表
     */

    private List<String> getKaiduList() {
        List<String> hour = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            hour.add(i + "%");
        }
        return hour;
    }

    private onCommitListener listener;

    public void setOnCommitListener(onCommitListener listener) {
        this.listener = listener;
    }


    interface onCommitListener {

        void commit(String startTime, String endTime, String kaidu);
    }
}
