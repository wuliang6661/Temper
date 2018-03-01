package com.myp.meiyuan.ui.main.person;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.myp.meiyuan.R;
import com.myp.meiyuan.mvp.MVPBaseFragment;
import com.myp.meiyuan.ui.updategreenhouse.UpdateGreenHouseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 我的
 */

public class PersonFragment extends MVPBaseFragment<PersonContract.View, PersonPresenter>
        implements PersonContract.View, View.OnClickListener {

    @Bind(R.id.update_greenhouse_name)
    RelativeLayout updateGreenhouseName;

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
        }
    }
}
