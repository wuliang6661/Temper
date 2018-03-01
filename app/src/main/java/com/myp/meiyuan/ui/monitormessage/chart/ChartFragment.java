package com.myp.meiyuan.ui.monitormessage.chart;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myp.meiyuan.R;
import com.myp.meiyuan.mvp.MVPBaseFragment;

/**
 * 图表模式
 */

public class ChartFragment extends MVPBaseFragment<ChartContract.View, ChartPresenter> implements ChartContract.View {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fra_chart, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
