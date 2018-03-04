package com.myp.meiyuan.ui.user_message;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.myp.meiyuan.R;
import com.myp.meiyuan.api.HttpService;
import com.myp.meiyuan.entity.ResultBo;
import com.myp.meiyuan.entity.UserBo;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.ui.updategreenhouse.update.UpdateActivity;
import com.myp.meiyuan.util.LogUtils;
import com.myp.meiyuan.widget.AvatarImageView;
import com.squareup.picasso.Picasso;

import java.io.File;

import butterknife.Bind;


/**
 * 用户信息
 */

public class User_messageActivity extends MVPBaseActivity<User_messageContract.View,
        User_messagePresenter> implements User_messageContract.View, View.OnClickListener {

    @Bind(R.id.add_devices)
    TextView addDevices;
    @Bind(R.id.person_image)
    AvatarImageView personImage;
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
    @Bind(R.id.person_img_layout)
    RelativeLayout personImgLayout;
    @Bind(R.id.person_name_layout)
    RelativeLayout personNameLayout;
    @Bind(R.id.sex_layout)
    RelativeLayout sexLayout;
    @Bind(R.id.phone_layout)
    RelativeLayout phoneLayout;
    @Bind(R.id.shouji_layout)
    RelativeLayout shoujiLayout;
    @Bind(R.id.email_layout)
    RelativeLayout emailLayout;
    @Bind(R.id.gongsi_layout)
    RelativeLayout gongsiLayout;
    @Bind(R.id.bumen_layout)
    RelativeLayout bumenLayout;
    @Bind(R.id.person_adress)
    TextView personAdress;
    @Bind(R.id.adress_layout)
    RelativeLayout adressLayout;

    private UserBo userBo;
    private String sex;


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

        mPresenter.getUserMessage();
        personNameLayout.setOnClickListener(this);
        sexLayout.setOnClickListener(this);
        phoneLayout.setOnClickListener(this);
        shoujiLayout.setOnClickListener(this);
        emailLayout.setOnClickListener(this);
        gongsiLayout.setOnClickListener(this);
        bumenLayout.setOnClickListener(this);
        adressLayout.setOnClickListener(this);
        addDevices.setOnClickListener(this);
        personImage.setContext(this);
        personImage.setFragmentManager(getSupportFragmentManager());
        personImage.setAfterCropListener(new AvatarImageView.AfterCropListener() {
            @Override
            public void afterCrop(Bitmap photo, File file) {
                LogUtils.I(file.getAbsolutePath());
                mPresenter.updataUserImage(photo);
            }
        });
    }

    @Override
    public void getUser(UserBo userBo) {
        this.userBo = userBo;
        inviView();
    }

    @Override
    public void updateImageSuress(ResultBo resultBo) {
        Picasso.with(this).load(HttpService.URL + "/xiaokedou1/images/" + resultBo.getMsg()).into(personImage);
        LogUtils.showToast("头像修改成功！");
    }

    @Override
    public void updateSuress() {
        LogUtils.showToast("修改成功！");
        finish();
    }


    private void inviView() {
        Picasso.with(this).load(HttpService.URL + "/xiaokedou1" + userBo.getTouxiangsrc()).into(personImage);
        personName.setText(userBo.getName());
        personPhone.setText(userBo.getTelPhone());
        personShouji.setText(userBo.getPhone());
        personEmail.setText(userBo.getEmail());
        personCompany.setText(userBo.getCompany());
        sex = userBo.getGender() + "";
        personSex.setText(userBo.getGender() == 0 ? "女" : "男");
        personDepartment.setText(userBo.getDept());
        personAdress.setText(userBo.getAddress());
        editDapeng.setText(userBo.getAddressDetail());
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, UpdateActivity.class);
        switch (view.getId()) {
            case R.id.person_img_layout:
                new AlertView("上传头像", null, "取消", null,
                        new String[]{"拍照", "从相册中选择"},
                        this, AlertView.Style.ActionSheet, new OnItemClickListener() {
                    @Override
                    public void onItemClick(Object o, int position) {

                    }
                }).setCancelable(true).show();
                break;
            case R.id.person_name_layout:
                intent.putExtra("isUserMessage", true);
                startActivityForResult(intent, 0x11);
                break;
            case R.id.sex_layout:
                new AlertView("选择性别", null, "取消", null,
                        new String[]{"女", "男"},
                        this, AlertView.Style.ActionSheet, new OnItemClickListener() {
                    @Override
                    public void onItemClick(Object o, int position) {
                        sex = position + "";
                        if (position == 0) {
                            personSex.setText("女");
                        } else if (position == 1) {
                            personSex.setText("男");
                        }
                    }
                }).setCancelable(true).show();
                break;
            case R.id.email_layout:
                intent.putExtra("isUserMessage", true);
                startActivityForResult(intent, 0x22);
                break;
            case R.id.phone_layout:
                intent.putExtra("isUserMessage", true);
                startActivityForResult(intent, 0x33);
                break;
            case R.id.shouji_layout:
                intent.putExtra("isUserMessage", true);
                startActivityForResult(intent, 0x44);
                break;
            case R.id.gongsi_layout:
                intent.putExtra("isUserMessage", true);
                startActivityForResult(intent, 0x55);
                break;
            case R.id.bumen_layout:
                intent.putExtra("isUserMessage", true);
                startActivityForResult(intent, 0x66);
                break;
            case R.id.adress_layout:
                intent.putExtra("isUserMessage", true);
                startActivityForResult(intent, 0x77);
                break;
            case R.id.add_devices:
                mPresenter.updateUserMessage(getText(personName), sex, getText(personPhone),
                        getText(personShouji), getText(personEmail), getText(personCompany), getText(personDepartment),
                        getText(personAdress), editDapeng.getText().toString().trim());
                break;
        }
    }

    private String getText(TextView view) {
        return view.getText().toString().trim();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        personImage.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        switch (requestCode) {
            case 0x11:
                personName.setText(data.getStringExtra("data"));
                break;
            case 0x22:
                personEmail.setText(data.getStringExtra("data"));
                break;
            case 0x33:
                personPhone.setText(data.getStringExtra("data"));
                break;
            case 0x44:
                personShouji.setText(data.getStringExtra("data"));
                break;
            case 0x55:
                personCompany.setText(data.getStringExtra("data"));
                break;
            case 0x66:
                personDepartment.setText(data.getStringExtra("data"));
                break;
            case 0x77:
                personAdress.setText(data.getStringExtra("data"));
                break;
        }
    }
}
