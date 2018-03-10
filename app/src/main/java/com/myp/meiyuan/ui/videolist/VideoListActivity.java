package com.myp.meiyuan.ui.videolist;


import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myp.meiyuan.R;
import com.myp.meiyuan.entity.VideoBo;
import com.myp.meiyuan.mvp.MVPBaseActivity;
import com.myp.meiyuan.ui.deviceadd.DeviceAddActivity;
import com.myp.meiyuan.ui.video.VideoActivity;
import com.myp.meiyuan.widget.lgrecycleadapter.LGRecycleViewAdapter;
import com.myp.meiyuan.widget.lgrecycleadapter.LGViewHolder;

import java.util.List;

import butterknife.Bind;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class VideoListActivity extends MVPBaseActivity<VideoListContract.View, VideoListPresenter>
        implements VideoListContract.View {

    @Bind(R.id.add_devices)
    TextView addDevices;
    @Bind(R.id.recycle)
    RecyclerView recycle;

    private String groupId;
    List<VideoBo> videoBos;

    @Override
    protected int getLayout() {
        return R.layout.act_recycleview;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goBack();
        setTitle("视频监控");
        addDevices.setText("添加设备");
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        recycle.setLayoutManager(manager);
        groupId = getIntent().getStringExtra("groupId");
        addDevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoListActivity.this, DeviceAddActivity.class);
                startActivity(intent);
            }
        });

        showProgress("加载中...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (videoBos==null) {
            mPresenter.getVideoNum(groupId);
        }
    }

    private void setAdapter(final List<VideoBo> videoBos) {
        LGRecycleViewAdapter<VideoBo> adapter = new LGRecycleViewAdapter<VideoBo>(videoBos) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_video;
            }

            @Override
            public void convert(LGViewHolder holder, VideoBo s, int position) {
                holder.setText(R.id.device_name, s.getDeviceName());
                ImageView point = (ImageView) holder.getView(R.id.connect_type_point);
                TextView connect_type_text = (TextView) holder.getView(R.id.connect_type_text);
                if (s.getState() == 1) {
                    point.setImageResource(R.drawable.point);
                    connect_type_text.setText("在线");
                    connect_type_text.setTextColor(Color.parseColor("#49baff"));
                } else {
                    point.setImageResource(R.drawable.hui_point);
                    connect_type_text.setText("离线");
                    connect_type_text.setTextColor(Color.parseColor("#999999"));
                }
                SurfaceView sfv = (SurfaceView) holder.getView(R.id.video);
                final MediaPlayer player = new MediaPlayer();
                try {
                    player.setDataSource(getContext(), Uri.parse(s.getLive_url()));
                    SurfaceHolder sh = sfv.getHolder();
                    sh.addCallback(new MyCallBack(player));
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
        };
        adapter.setOnItemClickListener(R.id.item_layout, new LGRecycleViewAdapter.ItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(VideoListActivity.this, VideoActivity.class);
                intent.putExtra("live_url", videoBos.get(position).getLive_url());
                startActivity(intent);
            }
        });
        recycle.setAdapter(adapter);
    }

    @Override
    public void getVideoList(List<VideoBo> videoBos) {
        this.videoBos = videoBos;
        setAdapter(videoBos);
    }


    private class MyCallBack implements SurfaceHolder.Callback {

        private MediaPlayer player;

        MyCallBack(MediaPlayer player) {
            this.player = player;
        }

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
}
