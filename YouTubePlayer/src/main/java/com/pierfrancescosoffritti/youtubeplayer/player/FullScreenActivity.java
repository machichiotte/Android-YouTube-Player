package com.pierfrancescosoffritti.youtubeplayer.player;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.pierfrancescosoffritti.youtubeplayer.R;

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
        }
    }


