package com.myp.meiyuan.ui.updategreenhouse.update;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.mvp.BasePresenterImpl;
import com.myp.meiyuan.util.LogUtils;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class UpdatePresenter extends BasePresenterImpl<UpdateContract.View> implements UpdateContract.Presenter {

    @Override
    public void updateName(String groupId, String groupName) {
        HttpServiceIml.updateGroupName(groupId, groupName).subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.E(e.getMessage());
                if (mView != null) {
                    mView.updateSuress();
                }
            }

            @Override
            public void onNext(Object str) {
                String s = (String) str;
                if (mView != null) {
                    if ("修改成功".equals(s)) {
                        LogUtils.showToast(s);
                        mView.updateSuress();
                    } else {
                        mView.onRequestError(s);
                    }
                }
            }
        });
    }
}
