package com.myp.meiyuan.ui.user_password;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.util.LogUtils;
import com.myp.meiyuan.util.StringUtils;

import butterknife.Bind;


/**
 * 修改密码
 */

public class User_passwordActivity extends MVPBaseActivity<User_passwordContract.View, User_passwordPresenter>
        implements User_passwordContract.View, View.OnClickListener {

    @Bind(R.id.add_devices)
    TextView addDevices;
    @Bind(R.id.edit_old_pwd)
    EditText editOldPwd;
    @Bind(R.id.edit_new_pwd)
    EditText editNewPwd;
    @Bind(R.id.edit_pwd)
    EditText editPwd;
    @Bind(R.id.commit)
    TextView commit;

    String strEditOldPwd;
    String strEditNewPwd;
    String strEditPwd;


    @Override
    protected int getLayout() {
        return R.layout.act_update_pwd;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goBack();
        setTitle("修改密码");
        addDevices.setVisibility(View.GONE);

        commit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commit:
                strEditOldPwd = editOldPwd.getText().toString().trim();
                strEditNewPwd = editNewPwd.getText().toString().trim();
                strEditPwd = editPwd.getText().toString().trim();
                if (StringUtils.isEmpty(strEditOldPwd)) {
                    LogUtils.showToast("请输入旧密码！");
                    return;
                }
                if (StringUtils.isEmpty(strEditNewPwd)) {
                    LogUtils.showToast("请输入新密码！");
                    return;
                }
                if (StringUtils.isEmpty(strEditPwd)) {
                    LogUtils.showToast("请确认新密码！");
                    return;
                }
                if (strEditNewPwd.equals(strEditOldPwd)) {
                    LogUtils.showToast("新密码不能和旧密码一样！");
                    return;
                }
                if (!strEditNewPwd.equals(strEditPwd)) {
                    LogUtils.showToast("两次输入密码不一致！");
                    return;
                }
                mPresenter.updatePassword( strEditOldPwd, strEditNewPwd, strEditPwd);
                break;
        }
    }

    @Override
    public void onSuress() {
        LogUtils.showToast("修改成功！");
        finish();
    }
}
