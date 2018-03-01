package com.myp.meiyuan.ui.controlmessage;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.myp.meiyuan.R;
import com.myp.meiyuan.widget.EasyPickView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuliang on 2018/2/28.
 * <p>
 * 模式选择弹窗
 */

public class ModeDialogFragment extends DialogFragment {


    EasyPickView easyPickview;
    Button commit;

    private OnConmitListener onConmitListener;


    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = Gravity.BOTTOM;
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(attributes);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_mode, container, false);
        //设置窗口以对话框样式显示
//		setStyle(DialogFragment.STYLE_NO_TITLE, R.style.dialog);
        //设置对话框背景色，否则有虚框
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置对话框弹出动画，从底部滑入，从底部滑出
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        getDialog().setCancelable(true);
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().getWindow().setGravity(Gravity.BOTTOM);

        easyPickview = (EasyPickView) view.findViewById(R.id.easy_pickview);
        commit = (Button) view.findViewById(R.id.commit);
        setData();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onConmitListener != null) {
                    onConmitListener.commit(easyPickview.getValue());
                }
            }
        });
    }

    /**
     * 为滑动设置数据
     */
    private void setData() {
        List<String> data = new ArrayList<>();
        data.add("自动");
        data.add("手动");
        easyPickview.setDataList(data);
    }


    interface OnConmitListener {

        void commit(String value);
    }

    public void setOnConmitListener(OnConmitListener listener) {
        this.onConmitListener = listener;
    }
}
