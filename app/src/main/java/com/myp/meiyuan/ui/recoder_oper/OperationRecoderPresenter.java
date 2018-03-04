package com.myp.meiyuan.ui.recoder_oper;

import com.myp.meiyuan.api.HttpServiceIml;
import com.myp.meiyuan.entity.OperationRecoderBo;
import com.myp.meiyuan.entity.WaitRecoderBo;
import com.myp.meiyuan.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class OperationRecoderPresenter extends BasePresenterImpl<OperationRecoderContract.View> implements OperationRecoderContract.Presenter {

    @Override
    public void getWaitRecoder() {
        HttpServiceIml.getWaitRecoders().subscribe(new Subscriber<List<WaitRecoderBo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<WaitRecoderBo> waitRecoderBos) {
                if (mView != null) {
                    mView.getWaitRecoder(waitRecoderBos);
                }
            }
        });
    }

    @Override
    public void getOperationRecoder() {
        HttpServiceIml.getOperationRecoders().subscribe(new Subscriber<List<OperationRecoderBo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<OperationRecoderBo> operationRecoderBos) {
                if (mView != null) {
                    mView.getOperationRecoder(operationRecoderBos);
                }
            }
        });
    }

    @Override
    public void getInvotionRecoder() {
        HttpServiceIml.getInvation().subscribe(new Subscriber<List<WaitRecoderBo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<WaitRecoderBo> waitRecoderBos) {
                if (mView != null) {
                    mView.getInvotionRecoder(waitRecoderBos);
                }
            }
        });
    }
}
