package com.bihanmahadewa.debugging;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int x = 10;
        printMe();
    }

    private void printMe(){
        System.out.println("HEY!");
    }
}
