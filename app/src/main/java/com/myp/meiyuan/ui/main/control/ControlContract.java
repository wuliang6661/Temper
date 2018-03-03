package com.myp.meiyuan.ui.main.control;

import com.myp.meiyuan.entity.FamenBo;
import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ControlContract {
    interface View extends BaseView {

        void showFamenList(List<FamenBo> famenBos);

        void getTab(List<GroupBO> groupBOs);

    }

    interface Presenter extends BasePresenter<View> {

        void getFamenList(String groupId);

        void getTab();

    }
}
