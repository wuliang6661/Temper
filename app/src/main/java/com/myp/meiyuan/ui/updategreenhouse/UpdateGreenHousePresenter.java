package com.myp.meiyuan.ui.updategreenhouse;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class UpdateGreenHousePresenter extends BasePresenterImpl<UpdateGreenHouseContract.View> implements UpdateGreenHouseContract.Presenter {

    @Override
    public void getGroupList() {
        HttpServiceIml.getGroupList().subscribe(new Subscriber<List<GroupBO>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<GroupBO> groupBOs) {
                if (mView != null) {
                    mView.showGroupList(groupBOs);
                }
            }
        });
    }
}
