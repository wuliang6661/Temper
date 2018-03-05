package com.myp.meiyuan.ui.main.control;

import android.content.Context;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.entity.FamenBo;
import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ControlPresenter extends BasePresenterImpl<ControlContract.View> implements ControlContract.Presenter {

    @Override
    public void getFamenList(String groupId) {
        HttpServiceIml.getFamenList(groupId).subscribe(new Subscriber<List<FamenBo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<FamenBo> famenBos) {
                if (mView != null) {
                    mView.showFamenList(famenBos);
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
