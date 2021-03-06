package com.myp.meiyuan.ui.deviceadd;

import android.content.Context;

import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

import org.json.JSONObject;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class DeviceAddContract {
    interface View extends BaseView {

        void onSuress();
    }

    interface  Presenter extends BasePresenter<View> {

        void addDevices(JSONObject object);
    }
}
