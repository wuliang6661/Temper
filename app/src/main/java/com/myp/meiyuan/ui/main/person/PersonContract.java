package com.myp.meiyuan.ui.main.person;

import com.myp.meiyuan.entity.UserBo;
import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class PersonContract {
    interface View extends BaseView {

        void getUser(UserBo userBo);
    }

    interface  Presenter extends BasePresenter<View> {

        void getUserMessage();
    }
}
