package com.myp.meiyuan.ui.recoder_oper;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.entity.OperationRecoderBo;
import com.myp.meiyuan.entity.WaitRecoderBo;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.widget.lgrecycleadapter.LGRecycleViewAdapter;
import com.myp.meiyuan.widget.lgrecycleadapter.LGViewHolder;

import java.util.List;

import butterknife.Bind;


/**
 * MVPPlugin
 * 操作记录
 */

public class OperationRecoderActivity extends MVPBaseActivity<OperationRecoderContract.View, OperationRecoderPresenter> implements OperationRecoderContract.View {

    @Bind(R.id.add_devices)
    TextView addDevices;
    @Bind(R.id.recycle)
    RecyclerView recycle;

    int type = 1;

    @Override
    protected int getLayout() {
        return R.layout.act_recycleview;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goBack();
        addDevices.setVisibility(View.GONE);
        inviView();
    }


    /**
     * 初始化布局
     */
    private void inviView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(manager);
        type = getIntent().getExtras().getInt("type");
        switch (type) {
            case 1:
                setTitle("操作记录");
                mPresenter.getOperationRecoder("ganzhou");
                break;
            case 2:
                setTitle("告警记录");
                mPresenter.getWaitRecoder("ganzhou");
                break;
            case 3:
                setTitle("红外入侵");
                break;
        }
    }


    @Override
    public void getWaitRecoder(List<WaitRecoderBo> waitRecoderBos) {
        setAdapter(waitRecoderBos);
    }

    @Override
    public void getOperationRecoder(List<OperationRecoderBo> operationRecoderBos) {
        setOperAdapter(operationRecoderBos);
    }


    /**
     * 设置告警记录数据适配器
     */
    private void setAdapter(List<WaitRecoderBo> waitRecoderBos) {
        LGRecycleViewAdapter<WaitRecoderBo> adapter = new LGRecycleViewAdapter<WaitRecoderBo>(waitRecoderBos) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_recoder;
            }

            @Override
            public void convert(LGViewHolder holder, WaitRecoderBo s, int position) {
                holder.getView(R.id.new_text).setVisibility(View.GONE);
                holder.setText(R.id.device_message, "ID:" + s.getId() + "设备，" + s.getRemark());
                holder.setText(R.id.recode_time, s.getTime());
            }
        };
        recycle.setAdapter(adapter);

    }


    /**
     * 设置操作记录数据适配器
     */
    private void setOperAdapter(List<OperationRecoderBo> waitRecoderBos) {
        LGRecycleViewAdapter<OperationRecoderBo> adapter = new LGRecycleViewAdapter<OperationRecoderBo>(waitRecoderBos) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_recoder;
            }

            @Override
            public void convert(LGViewHolder holder, OperationRecoderBo s, int position) {
                holder.getView(R.id.new_text).setVisibility(View.GONE);
                holder.setText(R.id.device_message, "ID:" + s.getDeviceId() + "设备，" + s.getOperation());
                holder.setText(R.id.recode_time, s.getTime());
            }
        };
        recycle.setAdapter(adapter);
    }
}
