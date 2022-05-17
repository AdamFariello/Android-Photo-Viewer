package com.example.androidphotos86;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidphotos86.userAndalbumHandler.newUser_Controller;

public class main extends AppCompatActivity {
    private ActivityResultLauncher<Intent> startForPhoto_view_controller;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launch_AlbumListController();
    }

    private void launch_AlbumListController() {
        try {
            Intent intent = new Intent(
                this, newUser_Controller.class
            );
            startActivity(intent);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}