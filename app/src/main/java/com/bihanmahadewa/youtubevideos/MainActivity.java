package com.bihanmahadewa.youtubevideos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.shankar.youtube_video_player.YoutubeVideoPlayer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        YoutubeVideoPlayer.playVideo(MainActivity.this, "XqZsoesa55w");
    }
}