package com.myp.meiyuan.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnDismissListener;
import com.bigkoo.alertview.OnItemClickListener;
import com.myp.meiyuan.R;
import com.myp.meiyuan.base.BaseActivity;
import com.myp.meiyuan.base.MyApplication;
import com.myp.meiyuan.config.LocalConfiguration;
import com.myp.meiyuan.ui.login.LoginActivity;
import com.myp.meiyuan.ui.user_message.User_messageActivity;
import com.myp.meiyuan.ui.user_password.User_passwordActivity;
import com.myp.meiyuan.util.AppManager;

import butterknife.Bind;

/**
 * Created by wuliang on 2018/3/2.
 * <p>
 * 设置界面
 */

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.add_devices)
    TextView addDevices;
    @Bind(R.id.person_message)
    RelativeLayout personMessage;
    @Bind(R.id.update_password)
    RelativeLayout updatePassword;
    @Bind(R.id.cancel_id)
    RelativeLayout cancelId;

    @Override
    protected int getLayout() {
        return R.layout.act_setting;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goBack();
        setTitle("设置");
        addDevices.setVisibility(View.GONE);

        personMessage.setOnClickListener(this);
        updatePassword.setOnClickListener(this);
        cancelId.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.person_message:
                gotoActivity(User_messageActivity.class, false);
                break;
            case R.id.update_password:
                gotoActivity(User_passwordActivity.class, false);
                break;
            case R.id.cancel_id:
                AlertView mAlertView = new AlertView("提示", "是否注销重新登录？", "取消", new String[]{"确定"},
                        null, SettingActivity.this,
                        AlertView.Style.Alert, new OnItemClickListener() {
                    @Override
                    public void onItemClick(Object o, int posi) {
                        if (posi == 0) {
                            MyApplication.sp.remove(LocalConfiguration.userName);
                            gotoActivity(LoginActivity.class, false);
                            AppManager.getAppManager().goBackMain();
                        }
                    }
                }).setCancelable(true).setOnDismissListener(new OnDismissListener() {
                    @Override
                    public void onDismiss(Object o) {

                    }
                });
                mAlertView.show();
                break;
        }

    }
}
