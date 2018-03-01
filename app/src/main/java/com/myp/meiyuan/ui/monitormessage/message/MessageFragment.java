package com.myp.meiyuan.ui.monitormessage.message;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.entity.DeviceBO;
import com.myp.meiyuan.entity.MonitorBo;
import com.myp.meiyuan.mvp.MVPBaseFragment;
import com.myp.meiyuan.widget.lgrecycleadapter.LGRecycleViewAdapter;
import com.myp.meiyuan.widget.lgrecycleadapter.LGViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 数据模式
 */

public class MessageFragment extends MVPBaseFragment<MessageContract.View, MessagePresenter>
        implements MessageContract.View, RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.value_danwei)
    TextView valueDanwei;
    @Bind(R.id.recycle)
    RecyclerView recycle;
    @Bind(R.id.radio_01)
    RadioButton radio01;
    @Bind(R.id.radio_02)
    RadioButton radio02;
    @Bind(R.id.radio_03)
    RadioButton radio03;
    @Bind(R.id.radio_04)
    RadioButton radio04;
    @Bind(R.id.radio_05)
    RadioButton radio05;
    @Bind(R.id.radio_layout)
    RadioGroup radioLayout;

    RadioButton[] radioButtons;
    DeviceBO deviceBO;


    public static MessageFragment newInstance(DeviceBO s) {
        MessageFragment myFragment = new MessageFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("deviceBo", s);
        myFragment.setArguments(bundle);
        return myFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_message, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        deviceBO = (DeviceBO) bundle.getSerializable("deviceBo");
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(manager);
        radioButtons = new RadioButton[]{radio01, radio02, radio03, radio04, radio05};
        radioLayout.setOnCheckedChangeListener(this);
        mPresenter.getSeashList(deviceBO.getDeviceTypeId() + "", deviceBO.getDeviceId() + "");
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i) {
            case R.id.radio_01:
                setRadio(0);
                break;
            case R.id.radio_02:
                setRadio(1);
                break;
            case R.id.radio_03:
                setRadio(2);
                break;
            case R.id.radio_04:
                setRadio(3);
                break;
            case R.id.radio_05:
                setRadio(4);
                break;
        }
    }

    /**
     * 设置radioButton显示
     */
    private void setRadio(int type) {
        for (int i = 0; i < radioButtons.length; i++) {
            if (type == i) {
                radioButtons[i].setTextColor(Color.parseColor("#ffffff"));
            } else {
                radioButtons[i].setTextColor(Color.parseColor("#49baff"));
            }
        }
    }


    /**
     * 设置数据
     */
    private void setAdapter(List<MonitorBo> list) {
        LGRecycleViewAdapter<MonitorBo> adapter = new LGRecycleViewAdapter<MonitorBo>(list) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_monitor;
            }

            @Override
            public void convert(LGViewHolder holder, MonitorBo s, int position) {
                holder.setText(R.id.xuhao, (position + 1) + "");
                holder.setText(R.id.item_time, s.getLastTime());
                holder.setText(R.id.item_value, s.getValue());
            }
        };
        recycle.setAdapter(adapter);
    }

    @Override
    public void getSearchList(List<MonitorBo> monitorBos) {
        setAdapter(monitorBos);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
