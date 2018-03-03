package com.myp.meiyuan.ui.user_message;

import android.content.Context;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.entity.UserBo;
import com.myp.meiyuan.mvp.BasePresenterImpl;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class User_messagePresenter extends BasePresenterImpl<User_messageContract.View> implements User_messageContract.Presenter {

    @Override
    public void getUserMessage(String userName) {
        HttpServiceIml.getUserMessage(userName).subscribe(new Subscriber<UserBo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserBo s) {

            }
        });
    }
}
