package com.myp.meiyuan.ui.controlmessage;

import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class ControlMessageContract {
    interface View extends BaseView {

        void sunress();
        
    }

    interface  Presenter extends BasePresenter<View> {

        void updateControl(String deviceTypeId, String deviceId, String switchStatus, String lastStatusChangeTime, String mode,
                           String timeParameters, String timeStatus,String firstLetter);
    }
}
