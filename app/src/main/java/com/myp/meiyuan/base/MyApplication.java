package com.myp.meiyuan.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.myp.meiyuan.util.Utils;

import cn.sharesdk.framework.ShareSDK;

/**
 * 作者 by wuliang 时间 16/10/26.
 * <p>
 * 程序的application
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        /***初始化工具类*/
        Utils.init(this);
        /***注册分享*/
        ShareSDK.initSDK(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
