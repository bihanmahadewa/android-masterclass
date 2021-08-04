package com.bihanmahadewa.videorecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback, View.OnClickListener {

    MediaRecorder mediaRecorder;
    SurfaceHolder holder;
    boolean recording = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SurfaceView surfaceView = findViewById(R.id.surface_view);
        mediaRecorder = new MediaRecorder();

        holder = surfaceView.getHolder();
        holder.addCallback(MainActivity.this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        surfaceView.setClickable(true);
        surfaceView.setOnClickListener(this);


        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.RECORD_AUDIO}, 0);
        } else if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 0);
        } else if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        } else {

            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
            mediaRecorder.setVideoSource(MediaRecorder.VideoSource.DEFAULT);


        }

    }

    void prepareRecorder(){
        CamcorderProfile camProfile = CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH);
        mediaRecorder.setProfile(camProfile);
        mediaRecorder.setOutputFile("/sdcard/custom_video.mp4");
        mediaRecorder.setMaxDuration(60000);
        mediaRecorder.setMaxFileSize(5000000);

        mediaRecorder.setPreviewDisplay(holder.getSurface());
        try {
            mediaRecorder.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
       prepareRecorder();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void onClick(View v) {
        if(recording){
            mediaRecorder.stop();
            recording = false;
            prepareRecorder();
        }else {
            recording = true;
            mediaRecorder.start();
        }
    }
}