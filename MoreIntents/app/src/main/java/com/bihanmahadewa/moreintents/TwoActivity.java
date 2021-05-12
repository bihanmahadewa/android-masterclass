package com.bihanmahadewa.moreintents;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class TwoActivity extends AppCompatActivity {

    TextView txtValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        txtValue = findViewById(R.id.txt_value);

        String myValue = getIntent().getExtras().getString("uniqueID");
        txtValue.setText(myValue);




    }
}
