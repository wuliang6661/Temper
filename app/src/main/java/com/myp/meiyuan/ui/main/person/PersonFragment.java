package com.myp.meiyuan.ui.main.person;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.api.HttpService;
import com.myp.meiyuan.entity.UserBo;
import com.myp.meiyuan.mvp.MVPBaseFragment;
import com.myp.meiyuan.ui.SettingActivity;
import com.myp.meiyuan.ui.recoder_oper.OperationRecoderActivity;
import com.myp.meiyuan.ui.updatedivicename.UpdateDiviceNameActivity;
import com.myp.meiyuan.ui.updategreenhouse.UpdateGreenHouseActivity;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 我的
 */

public class PersonFragment extends MVPBaseFragment<PersonContract.View, PersonPresenter>
        implements PersonContract.View, View.OnClickListener {

    @Bind(R.id.update_greenhouse_name)
    RelativeLayout updateGreenhouseName;
    @Bind(R.id.cazuo_recoder)
    RelativeLayout cazuoRecoder;
    @Bind(R.id.gaojing_recoder)
    RelativeLayout gaojingRecoder;
    @Bind(R.id.hongwai_recoder)
    RelativeLayout hongwaiRecoder;
    @Bind(R.id.update_device_name)
    RelativeLayout updateDeviceName;
    @Bind(R.id.setting)
    RelativeLayout setting;
    @Bind(R.id.person_img)
    CircleImageView personImg;
    @Bind(R.id.person_name)
    TextView personName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_person, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        updateGreenhouseName.setOnClickListener(this);
        cazuoRecoder.setOnClickListener(this);
        gaojingRecoder.setOnClickListener(this);
        hongwaiRecoder.setOnClickListener(this);
        updateDeviceName.setOnClickListener(this);
        setting.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getUserMessage();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update_greenhouse_name:
                Intent intent = new Intent(getActivity(), UpdateGreenHouseActivity.class);
                startActivity(intent);
                break;
            case R.id.cazuo_recoder:    //操作记录
                Bundle bundle = new Bundle();
                bundle.putInt("type", 1);
                gotoActivity(OperationRecoderActivity.class, bundle, false);
                break;
            case R.id.gaojing_recoder:   //告警记录
                Bundle bundle1 = new Bundle();
                bundle1.putInt("type", 2);
                gotoActivity(OperationRecoderActivity.class, bundle1, false);
                break;
            case R.id.hongwai_recoder:   //红外入侵
                Bundle bundle3 = new Bundle();
                bundle3.putInt("type", 3);
                gotoActivity(OperationRecoderActivity.class, bundle3, false);
                break;
            case R.id.update_device_name:   //修改设备名称
                gotoActivity(UpdateDiviceNameActivity.class, false);
                break;
            case R.id.setting:            //设置
                gotoActivity(SettingActivity.class, false);
                break;
        }
    }

    @Override
    public void getUser(UserBo userBo) {
        Picasso.with(getActivity()).load(HttpService.URL + "/xiaokedou1" + userBo.getTouxiangsrc()).into(personImg);
        personName.setText(userBo.getName());
    }
}
