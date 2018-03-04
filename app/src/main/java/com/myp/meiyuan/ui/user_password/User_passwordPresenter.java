package com.myp.meiyuan.ui.user_password;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.entity.ResultBo;
import com.myp.meiyuan.mvp.BasePresenterImpl;
import com.myp.meiyuan.util.LogUtils;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class User_passwordPresenter extends BasePresenterImpl<User_passwordContract.View> implements User_passwordContract.Presenter {

    @Override
    public void updatePassword(String oldPassword, String newPassword, String newPassword2) {
        HttpServiceIml.updatePassWord(oldPassword, newPassword, newPassword2).subscribe(new Subscriber<ResultBo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ResultBo s) {
                if (mView != null) {
                    if ("1".equals(s.getMsg())) {
                        mView.onSuress();
                    } else {
                        LogUtils.showToast("修改失败！");
                    }
                }
            }
        });
    }
}
