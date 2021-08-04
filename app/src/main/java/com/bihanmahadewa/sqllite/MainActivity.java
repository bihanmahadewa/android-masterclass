package com.bihanmahadewa.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase database = openOrCreateDatabase("testdb", MODE_PRIVATE, null);

        /*database.execSQL("CREATE TABLE users(username VARCHAR, password VARCHAR);");
        database.execSQL("INSERT INTO users VALUES('bihan', '1234');");*/

        Cursor results = database.rawQuery("SELECT * from users", null);
        results.moveToFirst();

        TextView textView = findViewById(R.id.txt_main);
        String username = results.getString(0);
        String password = results.getString(1);

        textView.setText("username: " + username + " | password: " + password);
    }
}