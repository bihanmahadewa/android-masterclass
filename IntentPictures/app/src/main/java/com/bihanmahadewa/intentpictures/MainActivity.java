package com.bihanmahadewa.intentpictures;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.FileUtils;
import android.provider.MediaStore;
import android.widget.Toast;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    File imageFile;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        imageFile = new File(MainActivity.this.getDataDir(), FilenameUtils.getNextFilename("jpg"));
        Uri uri = Uri.fromFile(imageFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        startActivityForResult(intent, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode){
            case Activity.RESULT_OK:
                if (imageFile.exists()) {

                }else{
                    Toast.makeText(MainActivity.this, "Image is Not Created", Toast.LENGTH_LONG).show();
                }

                break;
            case Activity.RESULT_CANCELED:
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                break;
                default:
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                    break;
        }

    }
}
