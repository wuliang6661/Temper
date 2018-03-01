package com.myp.meiyuan.ui.updategreenhouse;

import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class UpdateGreenHouseContract {
    interface View extends BaseView {

        void showGroupList(List<GroupBO> groupBOs);
    }

    interface Presenter extends BasePresenter<View> {

        /**
         * 获取大棚列表
         */
        void getGroupList();
    }
}
