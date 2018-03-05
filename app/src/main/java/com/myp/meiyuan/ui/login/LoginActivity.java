package com.myp.meiyuan.ui.login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.base.MyApplication;
import com.myp.meiyuan.config.LocalConfiguration;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.ui.main.MainActivity;
import com.myp.meiyuan.util.LogUtils;
import com.myp.meiyuan.util.StringUtils;

import butterknife.Bind;


/**
 * 登录
 */

public class LoginActivity extends MVPBaseActivity<LoginContract.View, LoginPresenter>
        implements LoginContract.View, View.OnClickListener {

    @Bind(R.id.commit)
    TextView commit;
    @Bind(R.id.edit_username)
    EditText editUsername;
    @Bind(R.id.edit_password)
    EditText editPassword;

    String userName;
    String password;

    @Override
    protected int getLayout() {
        return R.layout.act_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        commit.setOnClickListener(this);
        if (!StringUtils.isEmpty(MyApplication.sp.getString(LocalConfiguration.userName))) {
            gotoActivity(MainActivity.class, true);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commit:
                userName = editUsername.getText().toString().trim();
                password = editPassword.getText().toString().trim();
                if (StringUtils.isEmpty(userName)) {
                    LogUtils.showToast("请输入用户名！");
                    return;
                }
                if (StringUtils.isEmpty(password)) {
                    LogUtils.showToast("请输入密码！");
                    return;
                }
                mPresenter.login(userName, password);
                break;
        }

    }

    @Override
    public void onSouss() {
        MyApplication.sp.put(LocalConfiguration.userName, userName);
        gotoActivity(MainActivity.class, true);
    }
}
