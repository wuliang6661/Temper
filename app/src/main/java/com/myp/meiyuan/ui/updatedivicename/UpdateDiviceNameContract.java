package com.myp.meiyuan.ui.updatedivicename;

import com.myp.meiyuan.entity.DeviceAndGroupBo;
import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class UpdateDiviceNameContract {
    interface View extends BaseView {

        void getDeviceName(List<DeviceAndGroupBo> deviceAndGroupBos);
    }

    interface Presenter extends BasePresenter<View> {

        /**
         * 获取设备名称和所属分组
         */
        void getDeviceNameAndGroup();
    }
}
