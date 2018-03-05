package com.myp.meiyuan.ui.main.home;

import com.myp.meiyuan.entity.DeviceBO;
import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class HomeContract {
    interface View extends BaseView {

        void getDeviceList(List<DeviceBO> deviceBOs,String groupId);

        void getTab(List<GroupBO> groupBOs);

    }

    interface Presenter extends BasePresenter<View> {


        void getDeviceList(String groupId);


        void getTab();

    }
}
