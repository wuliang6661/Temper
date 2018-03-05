package com.myp.meiyuan.ui.updatedivicename.updatename;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.mvp.BasePresenterImpl;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class UpdateNamePresenter extends BasePresenterImpl<UpdateNameContract.View> implements UpdateNameContract.Presenter {

    @Override
    public void updateDeviceName(String deviceId, String deviceTypeId, String groupId, String deviceName) {
        HttpServiceIml.udpateDeviceName(deviceId, deviceTypeId, groupId, deviceName).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                if (mView != null) {
                    mView.onSuress();
                }
            }
        });
    }
}
