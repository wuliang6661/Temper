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
    public void updateControl(String deviceTypeId, String deviceId, String switchStatus, String lastStatusChangeTime, final String mode,
                              String timeParameters, String timeStatus,String firstLetter) {
        HttpServiceIml.updateControl(deviceTypeId, deviceId, switchStatus, lastStatusChangeTime, mode, timeParameters, timeStatus,firstLetter).subscribe(new Subscriber<Object>() {

            @Override
            public void onNext(Object o) {
                if(mView != null){
                    mView.sunress();
                }
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
