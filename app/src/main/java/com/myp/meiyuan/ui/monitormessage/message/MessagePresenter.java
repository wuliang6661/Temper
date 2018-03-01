package com.myp.meiyuan.ui.monitormessage.message;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.entity.MonitorBo;
import com.myp.meiyuan.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MessagePresenter extends BasePresenterImpl<MessageContract.View> implements MessageContract.Presenter {

    @Override
    public void getSeashList(String deviceTypeId, String deviceId) {
        HttpServiceIml.getDeviceSearch(deviceTypeId, deviceId).subscribe(new Subscriber<List<MonitorBo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<MonitorBo> monitorBos) {
                if (mView != null) {
                    mView.getSearchList(monitorBos);
                }
            }
        });
    }
}
