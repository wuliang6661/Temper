package com.myp.meiyuan.ui.video;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.mvp.MVPBaseActivity;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class VideoActivity extends MVPBaseActivity<VideoContract.View, VideoPresenter>
        implements VideoContract.View {

    private MediaPlayer player;


    @Override
    protected int getLayout() {
        return R.layout.act_video;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showProgress("加载中...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        SurfaceView sfv = (SurfaceView) findViewById(R.id.video);
        player = new MediaPlayer();
        try {
            String stream_url = getIntent().getStringExtra("live_url");
            player.setDataSource(this, Uri.parse(stream_url));
            SurfaceHolder sh = sfv.getHolder();
            sh.addCallback(new MyCallBack());
            player.prepareAsync();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    player.start();
                    player.setLooping(true);
                    stopProgress();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class MyCallBack implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            player.setDisplay(holder);
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    }


    @Override
    protected void onDestroy() {
        if (player != null) {
            player.release();
        }
        super.onDestroy();
    }
}
