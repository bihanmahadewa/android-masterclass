package com.bihanmahadewa.languageapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Locale locale = new Locale(PreferenceManager.getDefaultSharedPreferences(this).getString("locale", "en"));
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        this.getResources().updateConfiguration(configuration, this.getResources().getDisplayMetrics());
        setContentView(R.layout.activity_main);

        TextView txtView = findViewById(R.id.txt_main);
        Button btnEnglish = findViewById(R.id.btn_english);
        Button btnTamil = findViewById(R.id.btn_tamil);
        Button btnSpanish = findViewById(R.id.btn_spanish);

        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration configuration = new Configuration();
                configuration.locale = locale;
                getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                txtView.setText(R.string.text_main);
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putString("locale", "en").apply();
            }
        });

        btnTamil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("ta");
                Locale.setDefault(locale);
                Configuration configuration = new Configuration();
                configuration.locale = locale;
                getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                txtView.setText(R.string.text_main);
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putString("locale", "ta").apply();
            }
        });

        btnSpanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("es");
                Locale.setDefault(locale);
                Configuration configuration = new Configuration();
                configuration.locale = locale;
                getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                txtView.setText(R.string.text_main);
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().putString("locale", "es").apply();
            }
        });

    }
}