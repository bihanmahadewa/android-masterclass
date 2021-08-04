package com.bihanmahadewa.dialanumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dial();
    }

    void dial(){
        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:94718708080"));
            startActivity(intent);
        }else{
            String[] PERMISSION_STORAGE = {Manifest.permission.CALL_PHONE};
            ActivityCompat.requestPermissions(MainActivity.this, PERMISSION_STORAGE, 0);
            dial();
        }
    }
}