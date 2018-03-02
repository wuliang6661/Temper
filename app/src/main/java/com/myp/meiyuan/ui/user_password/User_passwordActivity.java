package com.myp.meiyuan.ui.user_password;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.mvp.MVPBaseActivity;

import butterknife.Bind;


/**
 * 修改密码
 */

public class User_passwordActivity extends MVPBaseActivity<User_passwordContract.View, User_passwordPresenter> implements User_passwordContract.View {

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

    }
}
