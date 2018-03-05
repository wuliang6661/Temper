package com.myp.meiyuan.ui.updatedivicename;

import android.content.Context;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.entity.DeviceAndGroupBo;
import com.myp.meiyuan.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class UpdateDiviceNamePresenter extends BasePresenterImpl<UpdateDiviceNameContract.View> implements UpdateDiviceNameContract.Presenter {

    @Override
    public void getDeviceNameAndGroup() {
        HttpServiceIml.getDeviceAndGroup().subscribe(new Subscriber<List<DeviceAndGroupBo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<DeviceAndGroupBo> deviceAndGroupBos) {
                if (mView != null) {
                    mView.getDeviceName(deviceAndGroupBos);
                }
            }
        });
    }
}
