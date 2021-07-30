package com.bihanmahadewa.twitterclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    final String TAG = this.getClass().getSimpleName();
    FirebaseAuth mAuth;
    DatabaseReference usersRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        usersRef = database.getReference("users");

        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button btnNext = findViewById(R.id.btn_next);
        EditText edtEmail = findViewById(R.id.edt_email);
        EditText edtPassword = findViewById(R.id.edt_password);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate(edtEmail.getText().toString(), edtPassword.getText().toString())){
                    //register user
                    login(edtEmail.getText().toString(), edtPassword.getText().toString());
                }else{
                    Toast.makeText(LoginActivity.this, "Fill in all the fields", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    Boolean validate(String uname, String pass){
        if(uname.equals("") || pass.equals("")){
            //user has not entered any data
            return false;
        }else{
            return true;
        }
    }

    void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(LoginActivity.this, "User successfully signed in", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            PreferenceManager.getDefaultSharedPreferences(LoginActivity.this).edit().putBoolean("is_user_logged", true).commit();
                            usersRef.child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    PreferenceManager.getDefaultSharedPreferences(LoginActivity.this).edit().putString("display_name", snapshot.child("name").getValue().toString()).commit();
                                    PreferenceManager.getDefaultSharedPreferences(LoginActivity.this).edit().putString("uname", snapshot.child("username").getValue().toString()).commit();
                                    startActivity(intent);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}