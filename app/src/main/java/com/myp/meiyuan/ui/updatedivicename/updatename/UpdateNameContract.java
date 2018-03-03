package com.myp.meiyuan.ui.updatedivicename.updatename;

import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class UpdateNameContract {
    interface View extends BaseView {

        void onSuress();

    }

    interface Presenter extends BasePresenter<View> {

        void updateDeviceName(String deviceId, String deviceTypeId, String groupId, String deviceName);

    }
}
