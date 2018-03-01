package com.myp.meiyuan.ui.main.home;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.entity.DeviceBO;
import com.myp.meiyuan.mvp.BasePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class HomePresenter extends BasePresenterImpl<HomeContract.View> implements HomeContract.Presenter {

    @Override
    public void getDeviceList() {
        HttpServiceIml.getDeviceList().subscribe(new Subscriber<List<DeviceBO>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d("wuliang", e.getMessage());
            }

            @Override
            public void onNext(List<DeviceBO> s) {
                if (mView != null) {
                    mView.getDeviceList(s);
                }
            }
        });
    }


    /**
     * 去掉所有反斜杠并将数据转为对象，后期最好后台返回不带反斜杠的数据
     */
    private void stringToObject(List<String> s) {
        List<String> newList = new ArrayList<>();
        for (String str : s) {
            newList.add(str.replaceAll("\\\\", ""));
        }
        List<DeviceBO> deviceBOs = new Gson().fromJson(newList.toString(), new TypeToken<List<DeviceBO>>() {
        }.getType());
        if (mView != null) {
            mView.getDeviceList(deviceBOs);
        }
    }


}
