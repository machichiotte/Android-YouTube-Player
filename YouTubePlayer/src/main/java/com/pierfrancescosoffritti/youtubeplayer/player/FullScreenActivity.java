package com.pierfrancescosoffritti.youtubeplayer.player;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.pierfrancescosoffritti.youtubeplayer.R;

/**
 * Created by Elias on 20/02/2018.
 */

public class FullScreenActivity extends Activity {
    private @Nullable
    YouTubePlayer initializedYouTubePlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.full_screen_layout);

        final String video_id = getIntent().getExtras().getString("VIDEO_ID");
        final float video_time = getIntent().getExtras().getFloat("VIDEO_TIME");

        YouTubePlayerView youTubePlayerView = findViewById(R.id.ytp);
        youTubePlayerView.playerUIControls.hideFullScreen();
        youTubePlayerView.initialize(new YouTubePlayerInitListener() {
            @Override
            public void onInitSuccess(final YouTubePlayer youTubePlayer) {
                youTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady() {
                        FullScreenActivity.this.initializedYouTubePlayer = youTubePlayer;
                        youTubePlayer.loadVideo(video_id, video_time);
                    }
                });
            }

        }, false);


    }

    @Override
    public void onBackPressed() {
        if (this.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            this.setRequestedOrientation(
                    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 500);
    }
}


