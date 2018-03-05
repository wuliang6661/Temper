package com.myp.meiyuan.ui.login;

import android.content.Context;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.mvp.BasePresenterImpl;
import com.myp.meiyuan.util.LogUtils;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter {

    @Override
    public void login(String userName, String password) {
        HttpServiceIml.userLogin(userName, password).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                if (mView != null) {
                    if ("200".equals(s)) {
                        mView.onSouss();
                    } else {
                        LogUtils.showToast("登录失败！请检查账号密码！");
                    }
                }
            }
        });
    }
}
