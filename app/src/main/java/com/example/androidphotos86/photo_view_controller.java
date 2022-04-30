package com.example.androidphotos86;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class photo_view_controller extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    ImageView imageView;

    protected void onCreate(Bundle savedInstanceState) {
        //Init
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_view);
        imageView = findViewById(R.id.imageView);
    }

    public void updateImageView(Photo photo) {
        imageView.setImageURI(photo.getUri());
    }

    public void bt_exit () {
        //TODO method will temporary open gallary
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);

        updateImageView(new Photo(gallery));
    }
}

