package com.bihanmahadewa.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    boolean playing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlay = findViewById(R.id.btn_play);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.bensound_anewbeginning);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playing){
                    mediaPlayer.stop();
                    playing = false;
                    btnPlay.setText("Play Music!");
                }else{
                    mediaPlayer.start();
                    playing = true;
                    btnPlay.setText("Stop Music!");
                }
            }
        });
    }
}