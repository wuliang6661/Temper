package com.myp.meiyuan.ui.main.home;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.entity.DeviceBO;
import com.myp.meiyuan.entity.GroupBO;
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
    public void getDeviceList(final String groupId) {
        HttpServiceIml.getDeviceList(groupId).subscribe(new Subscriber<List<DeviceBO>>() {
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
                    mView.getDeviceList(s,groupId);
                }
            }
        });
    }

    @Override
    public void getTab() {
        HttpServiceIml.getGroupList().subscribe(new Subscriber<List<GroupBO>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<GroupBO> groupBOs) {
                if(mView != null){
                    mView.getTab(groupBOs);
                }

            }});
    }
}
