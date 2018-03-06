package com.myp.meiyuan.ui.monitormessage.message;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.entity.DataBo;
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
    public void getSeashList(String deviceTypeId, String deviceId, String timeGap) {
        HttpServiceIml.getDeviceSearch(deviceTypeId, deviceId, timeGap).subscribe(new Subscriber<DataBo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(DataBo monitorBos) {
                if (mView != null) {
                    mView.getSearchList(monitorBos);
                }
            }
        });
    }
}
