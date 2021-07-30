package com.bihanmahadewa.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {
    EditText edtDob;
    Calendar calendar;
    String dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText edtName = findViewById(R.id.edt_name);
        EditText edtEmail = findViewById(R.id.edt_email);
        edtDob = findViewById(R.id.edt_dob);

        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDobEdt();
            }
        };

        edtDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(RegisterActivity.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        Button btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate(edtName.getText().toString(), edtEmail.getText().toString(), edtDob.getText().toString())){
                    Intent intent = new Intent(RegisterActivity.this, Register2Activity.class);
                    intent.putExtra("name", edtName.getText().toString());
                    intent.putExtra("email", edtEmail.getText().toString());
                    intent.putExtra("dob", dob);
                    startActivity(intent);
                }else{
                    Toast.makeText(RegisterActivity.this, "Fill in all the fields", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    Boolean validate(String name, String email, String dob){
        if(name.equals("") || email.equals("") || dob.equals("")){
            //user has not entered any data
            return false;
        }else{
            return true;
        }
    }

    void updateDobEdt(){
        String dateFormat = "MM/dd/yy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.US);
        edtDob.setText(simpleDateFormat.format(calendar.getTime()));
        dob = simpleDateFormat.format(calendar.getTime());
    }
}