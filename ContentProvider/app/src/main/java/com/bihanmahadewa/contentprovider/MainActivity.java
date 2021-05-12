package com.bihanmahadewa.contentprovider;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo = findViewById(R.id.btn_go);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = ContactsContract.Contacts.CONTENT_URI;
                System.out.println("MyURI: " + uri);
                Intent intent = new Intent(Intent.ACTION_PICK, uri);
                startActivityForResult(intent, 7707);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 7707){
            switch (resultCode){
                case Activity
                        .RESULT_OK:
                    Uri resultUri = data.getData();
                    Cursor cont = getContentResolver().query(resultUri, null, null, null, null);
                    if(!cont.moveToNext()){
                        Toast.makeText(MainActivity.this, "Cursor has no data", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if(cont.moveToFirst()){
                        String contactName = cont.getString(cont.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        System.out.println("Selected Contact Name: " + contactName);
                    }
                    break;
                default:
                    Toast.makeText(MainActivity.this, "Something went wrong, contact the developers", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}
