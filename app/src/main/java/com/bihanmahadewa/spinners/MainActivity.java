package com.bihanmahadewa.spinners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerDropdown = findViewById(R.id.spinner);
        String[] dropdownData = new String[]{"BMW", "Mercedes", "Tesla", "GMC"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, dropdownData);
        spinnerDropdown.setAdapter(adapter);

    }
}