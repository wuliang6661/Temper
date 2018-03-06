package com.myp.meiyuan.ui.monitormessage.chart;

import com.myp.meiyuan.entity.DataBo;
import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ChartContract {
    interface View extends BaseView {

        void getSearchList(DataBo monitorBos);

    }

    interface Presenter extends BasePresenter<View> {

        void getSeashList(String deviceTypeId, String deviceId, String timeGap);
    }
}
