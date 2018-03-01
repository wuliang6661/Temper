package com.myp.meiyuan.ui.updategreenhouse;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.ui.updategreenhouse.update.UpdateActivity;
import com.myp.meiyuan.widget.lgrecycleadapter.LGRecycleViewAdapter;
import com.myp.meiyuan.widget.lgrecycleadapter.LGViewHolder;

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

    @Override
    protected int getLayout() {
        return R.layout.act_update_green;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goBack();
        setTitle("修改大棚名称");
        addDevices.setVisibility(View.GONE);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(manager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getGroupList();
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
                Bundle bundle = new Bundle();
                bundle.putSerializable("groupBO", groupBOs.get(position));
                gotoActivity(UpdateActivity.class, bundle, false);
            }
        });
        recycle.setAdapter(adapter);
    }


    @Override
    public void showGroupList(List<GroupBO> groupBOs) {
        setAdapter(groupBOs);
    }
}
