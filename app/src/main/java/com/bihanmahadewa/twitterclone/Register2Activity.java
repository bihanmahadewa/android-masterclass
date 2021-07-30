package com.bihanmahadewa.twitterclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register2Activity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    String name, email, dob;
    private FirebaseAuth mAuth;
    EditText edtUname;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            //automatically login the user
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        name = getIntent().getStringExtra("name").toString();
        email = getIntent().getStringExtra("email");
        dob = getIntent().getStringExtra("dob");

        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        edtUname = findViewById(R.id.edt_uname);
        EditText edtPass = findViewById(R.id.edt_password);
        Button btnFinish = findViewById(R.id.btn_finish);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate(edtUname.getText().toString(), edtPass.getText().toString())){
                    //register user
                    register(email, edtPass.getText().toString());
                }else{
                    Toast.makeText(Register2Activity.this, "Fill in all the fields", Toast.LENGTH_LONG).show();
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

    void register(String email, String pass){
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Register2Activity.this, "User successfully created", Toast.LENGTH_LONG).show();
                            nextPage(user);
                        } else {
                            //Check if the user is already user
                            try{
                                throw task.getException();
                            }catch (FirebaseAuthUserCollisionException e){
                                //user is already registered
                                Toast.makeText(Register2Activity.this, "You are already registered into Twitter Clone",
                                        Toast.LENGTH_SHORT).show();
                            }catch (Exception e){
                                e.printStackTrace();
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Register2Activity.this, "Authentication failed. " + task.getException(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    void nextPage(FirebaseUser user){
        //change the user page after successful login
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference("users");
        userRef.child(user.getUid()).child("name").setValue(name);
        userRef.child(user.getUid()).child("dob").setValue(dob);
        userRef.child(user.getUid()).child("email").setValue(email);
        userRef.child(user.getUid()).child("username").setValue(edtUname.getText().toString());

        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("is_user_logged", true).commit();
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("display_name", name).commit();
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("uname", edtUname.getText().toString()).commit();

        Intent intent = new Intent(Register2Activity.this, HomeActivity.class);
        startActivity(intent);
    }

}