package com.myp.meiyuan.ui.monitormessage.chart;

import android.content.Context;

import com.myp.meiyuan.entity.MonitorBo;
import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class ChartContract {
    interface View extends BaseView {

        void getSearchList(List<MonitorBo> monitorBos);
        
    }

    interface  Presenter extends BasePresenter<View> {

        void getSeashList(String deviceTypeId, String deviceId);
    }
}
