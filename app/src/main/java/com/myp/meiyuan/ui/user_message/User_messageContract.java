package com.myp.meiyuan.ui.user_message;

import android.graphics.Bitmap;

import com.myp.meiyuan.entity.ResultBo;
import com.myp.meiyuan.entity.UserBo;
import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

import java.io.File;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class User_messageContract {
    interface View extends BaseView {


        void getUser(UserBo userBo);

        void updateImageSuress(ResultBo resultBo);

        void updateSuress();

    }

    interface Presenter extends BasePresenter<View> {


        void getUserMessage();

        void updateUserMessage(String realName, String gender, String telPhone, String mobile, String email,
                               String company, String dept, String address, String addressDetail);

        void updataUserImage(Bitmap file);
    }
}
