package com.myp.meiyuan.ui.monitormessage.chart;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.myp.meiyuan.R;
import com.myp.meiyuan.entity.DataBo;
import com.myp.meiyuan.entity.DeviceBO;
import com.myp.meiyuan.entity.MonitorBo;
import com.myp.meiyuan.mvp.MVPBaseFragment;
import com.myp.meiyuan.util.StringUtils;
import com.myp.meiyuan.util.TimeUtils;
import com.myp.meiyuan.widget.MyMarkerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 图表模式
 */

public class ChartFragment extends MVPBaseFragment<ChartContract.View, ChartPresenter>
        implements ChartContract.View, OnChartValueSelectedListener, RadioGroup.OnCheckedChangeListener {


    @Bind(R.id.chart1)
    LineChart mChart;

    DeviceBO deviceBO;
    @Bind(R.id.start_time)
    TextView startTime;
    @Bind(R.id.time)
    TextView time;
    @Bind(R.id.end_time)
    TextView endTime;
    @Bind(R.id.radio_01)
    RadioButton radio01;
    @Bind(R.id.radio_02)
    RadioButton radio02;
    @Bind(R.id.radio_03)
    RadioButton radio03;
    @Bind(R.id.radio_04)
    RadioButton radio04;
    @Bind(R.id.radio_layout)
    RadioGroup radioLayout;

    RadioButton[] radioButtons;
    YAxis leftAxis;
    YAxis rightAxis;
    @Bind(R.id.time_layout)
    LinearLayout timeLayout;


    public static ChartFragment newInstance(DeviceBO s) {
        ChartFragment myFragment = new ChartFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("deviceBo", s);
        myFragment.setArguments(bundle);
        return myFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_chart, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        deviceBO = (DeviceBO) bundle.getSerializable("deviceBo");

        invition();
        radioButtons = new RadioButton[]{radio01, radio02, radio03, radio04};
        radioLayout.setOnCheckedChangeListener(this);
        mPresenter.getSeashList(deviceBO.getDeviceTypeId() + "", deviceBO.getDeviceId() + "", "15");
    }


    /***
     * 设置界面
     */
    private void invition() {
        mChart.setOnChartValueSelectedListener(this);
        // no description text
        mChart.getDescription().setEnabled(false);
        // enable touch gestures
        mChart.setTouchEnabled(true);
        mChart.setDragDecelerationFrictionCoef(0.5f);
        // enable scaling and dragging
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setDrawGridBackground(false);
        mChart.setHighlightPerDragEnabled(true);
        // if disabled, scaling can be done on x- and y-axis separately
        mChart.setPinchZoom(true);
        // set an alternative background color
        MyMarkerView mv = new MyMarkerView(getActivity(), R.layout.custom_marker_view);
        mv.setChartView(mChart); // For bounds control
        mChart.setMarker(mv); // Set the marker to the chart
        mChart.setBackgroundColor(Color.WHITE);


        setData(new ArrayList<MonitorBo>());
        mChart.animateX(2500);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setTextSize(11f);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);

        leftAxis = mChart.getAxisLeft();
        leftAxis.setTextColor(Color.parseColor("#999999"));
        leftAxis.setAxisMaximum(40f);
        leftAxis.setAxisMinimum(10f);
        leftAxis.setDrawGridLines(true);
        leftAxis.setAxisLineColor(Color.WHITE);
        leftAxis.setGranularityEnabled(true);

        rightAxis = mChart.getAxisRight();
        rightAxis.setTextColor(Color.parseColor("#999999"));
        rightAxis.setAxisMaximum(40f);
        rightAxis.setAxisMinimum(10f);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawZeroLine(false);
        rightAxis.setAxisLineColor(Color.WHITE);
        rightAxis.setGranularityEnabled(false);
    }


    @Override
    public void getSearchList(DataBo monitorBos) {
        if (!StringUtils.isEmpty(monitorBos.getMax()) && !StringUtils.isEmpty(monitorBos.getMin())) {
            leftAxis.setAxisMaximum(Float.parseFloat(monitorBos.getMax()));
            leftAxis.setAxisMinimum(Float.parseFloat(monitorBos.getMin()));
            rightAxis.setAxisMaximum(Float.parseFloat(monitorBos.getMax()));
            rightAxis.setAxisMinimum(Float.parseFloat(monitorBos.getMin()));
        }
        if (!monitorBos.getData().isEmpty()) {
            if (monitorBos.getData().size() >= 2) {
                timeLayout.setVisibility(View.VISIBLE);
                startTime.setText(TimeUtils.string2String(monitorBos.getData().get(monitorBos.getData().size() - 1).getLastTime()));
                time.setText(TimeUtils.string2String(monitorBos.getData().get(monitorBos.getData().size() / 2).getLastTime()));
                endTime.setText(TimeUtils.string2String(monitorBos.getData().get(0).getLastTime()));
            } else {
                timeLayout.setVisibility(View.GONE);
            }
        }
        setData(monitorBos.getData());
    }


    private void setData(List<MonitorBo> monitorBos) {
        ArrayList<Entry> yVals1 = new ArrayList<>();
        int j = 0;
        for (int i = monitorBos.size() - 1; i >= 0; i--) {
            yVals1.add(new Entry((float) j, Float.parseFloat(monitorBos.get(i).getValue())));
            j++;
        }
        if (monitorBos.isEmpty()) {
            yVals1.add(new Entry(0, 0));
        }
        LineDataSet set1;
        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
            mChart.invalidate();
        } else {
            set1 = new LineDataSet(yVals1, "");
            set1.setAxisDependency(YAxis.AxisDependency.LEFT);
            set1.setColor(ColorTemplate.getHoloBlue());
            set1.setCircleColor(Color.parseColor("#49baff"));
            set1.setLineWidth(2f);
            set1.setCircleRadius(3f);
            set1.setFillAlpha(65);
            set1.setFillColor(ColorTemplate.getHoloBlue());
            set1.setHighLightColor(Color.rgb(244, 117, 117));
            set1.setDrawCircleHole(false);
            set1.setDrawCircles(false);
            set1.setDrawValues(false);
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            // create a data object with the datasets
            LineData data = new LineData(set1);
            data.setValueTextColor(Color.parseColor("#49baff"));
            data.setValueTextSize(9f);
            // set data
            mChart.setData(data);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i) {
            case R.id.radio_01:
                setRadio(0);
                mPresenter.getSeashList(deviceBO.getDeviceTypeId() + "", deviceBO.getDeviceId() + "", "15");
                break;
            case R.id.radio_02:
                setRadio(1);
                mPresenter.getSeashList(deviceBO.getDeviceTypeId() + "", deviceBO.getDeviceId() + "", "30");
                break;
            case R.id.radio_03:
                setRadio(2);
                mPresenter.getSeashList(deviceBO.getDeviceTypeId() + "", deviceBO.getDeviceId() + "", "60");
                break;
            case R.id.radio_04:
                setRadio(3);
                mPresenter.getSeashList(deviceBO.getDeviceTypeId() + "", deviceBO.getDeviceId() + "", "120");
                break;
        }
    }

    /**
     * 设置radioButton显示
     */
    private void setRadio(int type) {
        for (int i = 0; i < radioButtons.length; i++) {
            if (type == i) {
                radioButtons[i].setTextColor(Color.parseColor("#ffffff"));
            } else {
                radioButtons[i].setTextColor(Color.parseColor("#49baff"));
            }
        }
    }

}
