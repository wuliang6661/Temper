package com.myp.meiyuan.ui.videolist;

import android.content.Context;

import com.myp.meiyuan.entity.VideoBo;
import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class VideoListContract {
    interface View extends BaseView {

        void getVideoList(List<VideoBo> videoBos);
    }

    interface Presenter extends BasePresenter<View> {

        void getVideoNum(String groupId);
    }
}
