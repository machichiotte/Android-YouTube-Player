package com.pierfrancescosoffritti.youtubeplayer.player;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.pierfrancescosoffritti.youtubeplayer.R;
import com.pierfrancescosoffritti.youtubeplayer.ui.PlayerUIController;

/**
 * Created by Elias on 20/02/2018.
 */

public class FullScreenActivity extends Activity {

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

        youTubePlayerView.initialize(new YouTubePlayerInitListener() {
                                         @Override
                                         public void onInitSuccess(final YouTubePlayer youTubePlayer) {

                                             youTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                                                     @Override
                                                     public void onReady() {
                                                         youTubePlayer.loadVideo(video_id, video_time);
                                                     }
                                                 });
                                         }

    }, false);

        youTubePlayerView.playerUIControls.hideFullScreen();
    }

}


