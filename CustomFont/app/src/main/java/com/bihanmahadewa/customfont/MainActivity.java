package com.bihanmahadewa.customfont;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtTitle = findViewById(R.id.txt_title);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/stocky.ttf");
        txtTitle.setTypeface(typeface);

    }
}
