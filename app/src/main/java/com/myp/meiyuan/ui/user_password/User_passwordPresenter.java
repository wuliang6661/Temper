package com.myp.meiyuan.ui.user_password;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.mvp.BasePresenterImpl;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class User_passwordPresenter extends BasePresenterImpl<User_passwordContract.View> implements User_passwordContract.Presenter {

    @Override
    public void updatePassword(String userName, String oldPassword, String newPassword, String newPassword2) {
        HttpServiceIml.updatePassWord(userName, oldPassword, newPassword, newPassword2).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        });
    }
}
