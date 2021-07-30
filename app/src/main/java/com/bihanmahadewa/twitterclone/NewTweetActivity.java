package com.bihanmahadewa.twitterclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NewTweetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tweet);
        FirebaseApp.initializeApp(this);

        Button btnTweet = findViewById(R.id.btn_tweet);
        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference tweetRef = database.getReference("tweets");

        String displayName = PreferenceManager.getDefaultSharedPreferences(this).getString("display_name", "");
        String username = PreferenceManager.getDefaultSharedPreferences(this).getString("uname", "");

        EditText edtTweetMessage = findViewById(R.id.edt_tweet_message);
        btnTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtTweetMessage.getText().toString().equals("")) {
                    btnTweet.setEnabled(false);
                    String key = tweetRef.push().getKey();
                    tweetRef.child(key).child("message").setValue(edtTweetMessage.getText().toString());
                    tweetRef.child(key).child("display_name").setValue(displayName);
                    tweetRef.child(key).child("username").setValue(username);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mma MM/dd/yy", Locale.US);
                    String currentDnT = simpleDateFormat.format(new Date());
                    tweetRef.child(key).child("time_published").setValue(currentDnT).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            onBackPressed();
                        }
                    }).addOnCanceledListener(new OnCanceledListener() {
                        @Override
                        public void onCanceled() {
                            Toast.makeText(NewTweetActivity.this, "Something went wrong while saving your tweet", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(NewTweetActivity.this, "Enter your tweet first", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}