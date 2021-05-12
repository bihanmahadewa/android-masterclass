package com.bihanmahadewa.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        String url = "https://yahoo.com";
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//        startActivity(intent);

//        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+16508750233"));
//        startActivity(callIntent);

//        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=0RFumQ8Q8f8"));
//        startActivity(appIntent);

        Intent ytIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
        startActivity(ytIntent);

    }
}
