package com.myp.meiyuan.ui.login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.ui.main.MainActivity;

import butterknife.Bind;


/**
 * 登录
 */

public class LoginActivity extends MVPBaseActivity<LoginContract.View, LoginPresenter>
        implements LoginContract.View, View.OnClickListener {

    @Bind(R.id.commit)
    TextView commit;

    @Override
    protected int getLayout() {
        return R.layout.act_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        commit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commit:
                gotoActivity(MainActivity.class, true);
                break;
        }

    }
}
