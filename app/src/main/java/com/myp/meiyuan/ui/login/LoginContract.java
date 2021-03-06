package com.myp.meiyuan.ui.login;

import android.content.Context;

import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LoginContract {
    interface View extends BaseView {

        void onSouss();
    }

    interface Presenter extends BasePresenter<View> {

        void login(String userName, String password);
    }
}
