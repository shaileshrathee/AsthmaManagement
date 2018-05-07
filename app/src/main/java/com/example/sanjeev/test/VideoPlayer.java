package com.example.sanjeev.test;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        VideoView view = findViewById(R.id.video_view);
        view.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoplayback));
        view.start();
    }
}
