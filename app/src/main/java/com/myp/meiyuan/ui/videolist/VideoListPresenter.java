package com.myp.meiyuan.ui.videolist;

import android.content.Context;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.entity.VideoBo;
import com.myp.meiyuan.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class VideoListPresenter extends BasePresenterImpl<VideoListContract.View> implements
        VideoListContract.Presenter {

    @Override
    public void getVideoNum(String groupId) {
        HttpServiceIml.getVideoList(groupId).subscribe(new Subscriber<List<VideoBo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<VideoBo> videoBos) {
                if (mView != null) {
                    mView.getVideoList(videoBos);
                }
            }
        });
    }
}
