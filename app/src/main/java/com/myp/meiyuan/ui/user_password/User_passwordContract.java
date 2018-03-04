package com.myp.meiyuan.ui.user_password;

import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class User_passwordContract {
    interface View extends BaseView {

        void onSuress();
    }

    interface  Presenter extends BasePresenter<View> {

        void updatePassword( String oldPassword, String newPassword, String newPassword2);
    }
}
