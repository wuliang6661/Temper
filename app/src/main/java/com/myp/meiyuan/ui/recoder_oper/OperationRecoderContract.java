package com.myp.meiyuan.ui.recoder_oper;

import com.myp.meiyuan.entity.OperationRecoderBo;
import com.myp.meiyuan.entity.WaitRecoderBo;
import com.myp.meiyuan.mvp.BasePresenter;
import com.myp.meiyuan.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class OperationRecoderContract {
    interface View extends BaseView {

        void getWaitRecoder(List<WaitRecoderBo> waitRecoderBos);

        void getOperationRecoder(List<OperationRecoderBo> operationRecoderBos);

        void getInvotionRecoder(List<WaitRecoderBo> waitRecoderBos);

    }

    interface Presenter extends BasePresenter<View> {

        /**
         * 获取告警记录
         */
        void getWaitRecoder();

        /**
         * 获取操作记录
         */
        void getOperationRecoder();


        void getInvotionRecoder();

    }
}
