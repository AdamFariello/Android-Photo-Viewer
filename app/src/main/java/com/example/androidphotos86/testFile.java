package com.example.androidphotos86;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import java.util.LinkedList;

public class testFile extends AppCompatActivity {
    private ActivityResultLauncher<Intent> startForPhoto_view_controller;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.photo_view);
        launch_PhotoViewController();
    }

    private void launch_PhotoViewController() {
        Intent intent = new Intent(this, photo_view_controller.class);
        startActivity(intent);
    }
}