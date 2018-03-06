package com.myp.meiyuan.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.bigkoo.svprogresshud.SVProgressHUD;

/**
 * Created by wuliang on 2018/3/2.
 * <p>
 * 所有fragment的父类
 */

public abstract class BaseFragment extends Fragment {

    private SVProgressHUD svProgressHUD;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        svProgressHUD = new SVProgressHUD(getActivity());
    }

    /**
     * 常用的跳转方法
     */
    public void gotoActivity(Class<?> cls, boolean isFinish) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
        if (isFinish) {
            getActivity().finish();
        }
    }

    public void gotoActivity(Class<?> cls, Bundle bundle, boolean isFinish) {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtras(bundle);
        startActivity(intent);
        if (isFinish) {
            getActivity().finish();
        }
    }


    /**
     * 显示加载进度弹窗,点击屏幕消失
     */
    protected void showProgress(String msg) {
        svProgressHUD.showWithStatus(msg, SVProgressHUD.SVProgressHUDMaskType.BlackCancel);
    }

    /**
     * 显示加载进度弹窗,点击屏幕不可消失
     */
    protected void showNoProgress(String msg) {
        svProgressHUD.showWithStatus(msg, SVProgressHUD.SVProgressHUDMaskType.Black);
    }

    /**
     * 停止弹窗
     */
    protected void stopProgress() {
        if (svProgressHUD.isShowing()) {
            svProgressHUD.dismiss();
        }
    }
}
