package com.myp.meiyuan.ui.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.myp.meiyuan.R;
import com.myp.meiyuan.base.BaseActivity;
import com.myp.meiyuan.ui.main.control.ControlFragment;
import com.myp.meiyuan.ui.main.home.HomeFragment;
import com.myp.meiyuan.ui.main.person.PersonFragment;
import com.myp.meiyuan.util.AppManager;
import com.xyz.tabitem.BottmTabItem;

import butterknife.Bind;

/**
 * 首页
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.main1)
    BottmTabItem main1;
    @Bind(R.id.main2)
    BottmTabItem main2;
    @Bind(R.id.main3)
    BottmTabItem main3;

    HomeFragment homeFragment;
    ControlFragment controlFragment;
    PersonFragment personFragment;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeFragment = new HomeFragment();
        controlFragment = new ControlFragment();
        personFragment = new PersonFragment();
        goToFragment(homeFragment);
        main1.setOnClickListener(this);
        main2.setOnClickListener(this);
        main3.setOnClickListener(this);
    }

    private Fragment mContent = null;

    /**
     * 修改显示的内容 不会重新加载
     **/
    public void goToFragment(Fragment to) {
        if (mContent != to) {
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                if (mContent != null)
                    transaction.hide(mContent).add(R.id.fragment_container, to).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
                else
                    transaction.add(R.id.fragment_container, to).commitAllowingStateLoss();
            } else {
                if (mContent != null)
                    transaction.hide(mContent).show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
                else
                    transaction.show(to).commitAllowingStateLoss();
            }
            mContent = to;
        }
    }

    /**
     * 底部按钮点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main1:
                goToFragment(homeFragment);
                main1.setSelectState(true);
                main2.setSelectState(false);
                main3.setSelectState(false);
                break;
            case R.id.main2:
                goToFragment(controlFragment);
                main1.setSelectState(false);
                main2.setSelectState(true);
                main3.setSelectState(false);
                break;
            case R.id.main3:
                goToFragment(personFragment);
                main1.setSelectState(false);
                main2.setSelectState(false);
                main3.setSelectState(true);
                break;

        }
    }

    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    firstTime = secondTime;
                    return true;
                } else {
                    AppManager.getAppManager().finishAllActivity();
                    System.exit(0);
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }
}
