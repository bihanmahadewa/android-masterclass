package com.bihanmahadewa.netinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        boolean netAvailable = networkInfo.isAvailable();
        boolean connected = networkInfo.isConnected();
        boolean roaming = networkInfo.isRoaming();
        int networkType = networkInfo.getType();
        String networkName = networkInfo.getTypeName();

    }
}