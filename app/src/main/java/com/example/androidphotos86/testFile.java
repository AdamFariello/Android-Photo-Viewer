package com.example.androidphotos86;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidphotos86.photoTools.*;
import java.util.ArrayList;

public class testFile extends AppCompatActivity {
    private ActivityResultLauncher<Intent> startForPhoto_view_controller;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.photo_view);

        //Launchers (test/code to steal for other implementation)
        //launch_AlbumListController();

        ArrayList<Foto> photos = new ArrayList<Foto>();
    }

    /*
    private void launch_AlbumListController() {
        Intent intent = new Intent(this, album_list_controller.class);
        startActivity(intent);
    }

    private void launch_PhotoListController() {
        Intent intent = new Intent(this, photo_list_controller.class);
        startActivity(intent);
    }

    private void launch_PhotoViewController() {
        Intent intent = new Intent(this, photo_view_controller.class);
        startActivity(intent);
    }
     */
}