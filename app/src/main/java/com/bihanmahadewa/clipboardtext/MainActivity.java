package com.bihanmahadewa.clipboardtext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtMain = findViewById(R.id.txt_main);
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        String clip = clipboardManager.getText().toString();
        txtMain.setText(clip);

    }
}