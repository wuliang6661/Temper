package com.myp.meiyuan.ui.updategreenhouse.update;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.util.LogUtils;
import com.myp.meiyuan.util.StringUtils;

import butterknife.Bind;


/**
 * 修改名称
 */

public class UpdateActivity extends MVPBaseActivity<UpdateContract.View, UpdatePresenter> implements UpdateContract.View, View.OnClickListener {

    @Bind(R.id.add_devices)
    TextView addDevices;
    @Bind(R.id.edit_dapeng)
    EditText editDapeng;

    GroupBO groupBO;

    boolean isUserMessage = false;
    private InputMethodManager imm;

    @Override
    protected int getLayout() {
        return R.layout.act_update;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        goBack();
        setTitle("修改");
        addDevices.setText("完成");
        addDevices.setOnClickListener(this);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        isUserMessage = getIntent().getBooleanExtra("isUserMessage", false);
        if (isUserMessage) {
            editDapeng.setHint("请输入信息");
        } else {
            groupBO = (GroupBO) getIntent().getExtras().getSerializable("groupBO");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_devices:
                //关闭软键盘
                imm.hideSoftInputFromWindow(editDapeng.getWindowToken(), 0);
                String name = editDapeng.getText().toString().trim();
                if (StringUtils.isEmpty(name)) {
                    LogUtils.showToast("请输入名称!");
                } else {
                    if (isUserMessage) {
                        Intent intent = new Intent();
                        intent.putExtra("data", name);
                        setResult(0x11, intent);
                        finish();
                    } else {
                        mPresenter.updateName(groupBO.getGroupId() + "", name);
                    }
                }
                break;
        }
    }

    @Override
    public void updateSuress() {
        finish();
    }

    @Override
    public void onRequestError(String msg) {
        LogUtils.showToast(msg);
    }

    @Override
    public void onRequestEnd() {

    }
}
