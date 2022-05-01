package com.example.androidphotos86.controllers;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.cast.framework.media.ImagePicker;
import java.io.FileNotFoundException;
import com.example.androidphotos86.R;
import com.example.androidphotos86.model.Photo;

public class photo_view_controller extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    ImageView imageView;

    protected void onCreate(Bundle savedInstanceState) {
        //Init
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_view);

        //Calls
        imageView = findViewById(R.id.imasgeView);
    }

    public void bt_exit (View view) {
        ImagePicker.Companion.with((photo_view_controller.this)
            .compress(1024)
            .maxResultSize(1080, 1080)
            .start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            Photo photo = new Photo(data);
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(
                        getContentResolver().openInputStream(photo.getUri())
                );
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}