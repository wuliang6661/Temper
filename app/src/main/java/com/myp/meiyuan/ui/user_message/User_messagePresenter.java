package com.myp.meiyuan.ui.user_message;

import android.graphics.Bitmap;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.entity.ResultBo;
import com.myp.meiyuan.entity.UserBo;
import com.myp.meiyuan.mvp.BasePresenterImpl;
import com.myp.meiyuan.util.BitmapUtils;
import com.myp.meiyuan.util.LogUtils;
import com.myp.meiyuan.util.StringUtils;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class User_messagePresenter extends BasePresenterImpl<User_messageContract.View> implements User_messageContract.Presenter {

    @Override
    public void getUserMessage() {
        HttpServiceIml.getUserMessage().subscribe(new Subscriber<UserBo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserBo s) {
                if (mView != null) {
                    mView.getUser(s);
                }
            }
        });
    }

    @Override
    public void updateUserMessage(String realName, String gender, String telPhone, String mobile, String email,
                                  String company, String dept, String address, String addressDetail) {
        if (StringUtils.isEmpty(realName) || StringUtils.isEmpty(gender) || StringUtils.isEmpty(telPhone)
                || StringUtils.isEmpty(mobile) || StringUtils.isEmpty(email) || StringUtils.isEmpty(company)
                || StringUtils.isEmpty(dept) || StringUtils.isEmpty(address) ||
                StringUtils.isEmpty(addressDetail)) {
            LogUtils.showToast("所有信息都为必填项！");
            return;
        }
        HttpServiceIml.updateUser(realName, gender, telPhone, mobile, email, company, dept, address, addressDetail).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                if (mView != null) {
                    if ("200".equals(s)) {
                        mView.updateSuress();
                    } else {
                        LogUtils.showToast("修改失败！");
                    }
                }
            }
        });
    }

    @Override
    public void updataUserImage(Bitmap file) {
        HttpServiceIml.updateUserImage(BitmapUtils.bitmapToBase64(file)).subscribe(new Subscriber<ResultBo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ResultBo resultBo) {
                if(mView != null){
                    mView.updateImageSuress(resultBo);
                }
            }
        });
    }
}
