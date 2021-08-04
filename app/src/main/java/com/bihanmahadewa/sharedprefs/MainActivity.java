package com.bihanmahadewa.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtMain = findViewById(R.id.txt_main);
//        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("uname", "bihan").commit();

        txtMain.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("uname", "").toString());
    }
}