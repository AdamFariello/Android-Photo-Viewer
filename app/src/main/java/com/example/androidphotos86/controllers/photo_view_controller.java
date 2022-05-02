package com.example.androidphotos86.controllers;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;

public class photo_view_controller extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    ImageView imageView;

    /* TODO EVERYTHING
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
    */
}