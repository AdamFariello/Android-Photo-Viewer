package com.example.androidphotos86;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class photo_view_controller extends AppCompatActivity {
    ImageView imageView;

    protected void onCreate(Bundle savedInstanceState) {
        //Init
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_view);
        imageView = findViewById(R.id.imageView);
    }
    private void updateImageView(Photo photo) {
        imageView.setImageURI(photo.getUri());
    }

    private void bt_exit () {
        //TODO method will temporary open gallary
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);

        Photo photo = new Photo(gallary);
    }
}
