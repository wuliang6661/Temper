package com.myp.meiyuan.ui.user_message;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.mvp.MVPBaseActivity;

import butterknife.Bind;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * 用户信息
 */

public class User_messageActivity extends MVPBaseActivity<User_messageContract.View, User_messagePresenter> implements User_messageContract.View {

    @Bind(R.id.add_devices)
    TextView addDevices;
    @Bind(R.id.person_image)
    CircleImageView personImage;
    @Bind(R.id.person_name)
    TextView personName;
    @Bind(R.id.person_sex)
    TextView personSex;
    @Bind(R.id.person_phone)
    TextView personPhone;
    @Bind(R.id.person_shouji)
    TextView personShouji;
    @Bind(R.id.person_email)
    TextView personEmail;
    @Bind(R.id.person_company)
    TextView personCompany;
    @Bind(R.id.person_department)
    TextView personDepartment;
    @Bind(R.id.edit_dapeng)
    EditText editDapeng;

    @Override
    protected int getLayout() {
        return R.layout.act_user_message;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        goBack();
        setTitle("个人信息");
        addDevices.setText("完成");

        mPresenter.getUserMessage("ganzhou");
    }
}
