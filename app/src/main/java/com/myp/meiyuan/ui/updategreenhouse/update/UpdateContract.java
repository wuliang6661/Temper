package com.myp.meiyuan.ui.updategreenhouse.update;

import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseRequestView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class UpdateContract {
    interface View extends BaseRequestView {

        void updateSuress();
    }

    interface Presenter extends BasePresenter<View> {

        void updateName(String groupId, String groupNameo);
    }
}
