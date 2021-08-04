package com.bihanmahadewa.intentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtSecond = findViewById(R.id.txt_second);
        txtSecond.setText(String.valueOf(getIntent().getIntExtra("secret_code", 0)));
    }
}