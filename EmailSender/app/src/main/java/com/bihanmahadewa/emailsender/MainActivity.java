package com.bihanmahadewa.emailsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtBody;
    Button btnSend;
    EditText edtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        txtBody = findViewById(R.id.txt_email_body);
        btnSend = findViewById(R.id.btn_send);
        edtInput = findViewById(R.id.edt_input);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/html");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "This is the email subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, edtInput.getText().toString());
                startActivity(emailIntent);
            }
        });

    }
}
