package com.myp.meiyuan.ui.main.person;

import android.content.Context;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.entity.UserBo;
import com.myp.meiyuan.mvp.BasePresenterImpl;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PersonPresenter extends BasePresenterImpl<PersonContract.View> implements PersonContract.Presenter {
    @Override
    public void getUserMessage() {
        HttpServiceIml.getUserMessage().subscribe(new Subscriber<UserBo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserBo s) {
                if (mView != null) {
                    mView.getUser(s);
                }
            }
        });
    }
}
