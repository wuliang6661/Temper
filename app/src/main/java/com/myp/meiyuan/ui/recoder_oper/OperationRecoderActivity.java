package com.myp.meiyuan.ui.recoder_oper;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.widget.lgrecycleadapter.LGRecycleViewAdapter;
import com.myp.meiyuan.widget.lgrecycleadapter.LGViewHolder;

import java.util.ArrayList;
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
        type = getIntent().getExtras().getInt("type");
        switch (type) {
            case 1:
                setTitle("操作记录");
                break;
            case 2:
                setTitle("告警记录");
                break;
            case 3:
                setTitle("红外入侵");
                break;
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(manager);

        List<String> lists = new ArrayList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        setAdapter(lists);
    }


    /**
     * 设置数据适配器
     */
    private void setAdapter(List<String> list) {
        LGRecycleViewAdapter<String> adapter = new LGRecycleViewAdapter<String>(list) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_recoder;
            }

            @Override
            public void convert(LGViewHolder holder, String s, int position) {

            }
        };
        recycle.setAdapter(adapter);
    }

}
