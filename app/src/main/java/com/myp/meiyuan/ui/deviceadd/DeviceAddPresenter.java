package com.myp.meiyuan.ui.deviceadd;

import android.content.Context;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.entity.ResultBo;
import com.myp.meiyuan.mvp.BasePresenterImpl;
import com.myp.meiyuan.util.LogUtils;

import org.json.JSONObject;

import rx.Subscriber;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class DeviceAddPresenter extends BasePresenterImpl<DeviceAddContract.View> implements DeviceAddContract.Presenter{

    @Override
    public void addDevices(JSONObject object) {
        HttpServiceIml.addDevice(object).subscribe(new Subscriber<ResultBo>() {
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
