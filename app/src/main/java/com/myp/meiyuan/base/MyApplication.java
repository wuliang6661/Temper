package com.myp.meiyuan.base;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import android.support.multidex.MultiDex;

import com.myp.meiyuan.util.SPUtils;
import com.myp.meiyuan.util.Utils;

import cn.sharesdk.framework.ShareSDK;

/**
 * 作者 by wuliang 时间 16/10/26.
 * <p>
 * 程序的application
 */

public class MyApplication extends Application {

    public static SPUtils sp;


    @Override
    public void onCreate() {
        super.onCreate();
        /***初始化工具类*/
        Utils.init(this);

        sp = new SPUtils("temper");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            builder.detectFileUriExposure();
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
