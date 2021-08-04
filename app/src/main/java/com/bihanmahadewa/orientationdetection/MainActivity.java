package com.bihanmahadewa.orientationdetection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            //it is landscape
            Toast.makeText(MainActivity.this, "Landscape Orientation", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this, "Portrait Orientation", Toast.LENGTH_LONG).show();
        }
    }
}