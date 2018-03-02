package com.myp.meiyuan.ui.updatedivicename;


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
 * 修改设备名称
 */

public class UpdateDiviceNameActivity extends MVPBaseActivity<UpdateDiviceNameContract.View, UpdateDiviceNamePresenter> implements UpdateDiviceNameContract.View {

    @Bind(R.id.add_devices)
    TextView addDevices;
    @Bind(R.id.recycle)
    RecyclerView recycle;

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

        List<String> lists = new ArrayList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        setAdapter(lists);
    }


    private void setAdapter(List<String> list) {
        LGRecycleViewAdapter<String> adapter = new LGRecycleViewAdapter<String>(list) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_device_name;
            }

            @Override
            public void convert(LGViewHolder holder, String s, int position) {

            }
        };
        recycle.setAdapter(adapter);
    }
}
