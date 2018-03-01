package com.myp.meiyuan.ui.controlmessage;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.mvp.BasePresenterImpl;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ControlMessagePresenter extends BasePresenterImpl<ControlMessageContract.View> implements ControlMessageContract.Presenter {

    @Override
    public void updateControl(String deviceTypeId, String deviceId, String estate, String lastStatusChangeTime, final String mode,
                              String timeParameters, String timeStatus) {
        HttpServiceIml.updateControl(deviceTypeId, deviceId, estate, lastStatusChangeTime, mode, timeParameters, timeStatus).subscribe(new Subscriber<Object>() {

            @Override
            public void onNext(Object o) {

            }


            @Override
            public void onError(Throwable e) {
                if(mView != null){
                    mView.sunress();
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
