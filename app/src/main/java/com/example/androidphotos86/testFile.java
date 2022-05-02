package com.example.androidphotos86;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

//import com.example.androidphotos86.controllers.album_list_controller;
import com.example.androidphotos86.photoTools.*;
import com.example.androidphotos86.tools.Serialize;

import java.util.ArrayList;

public class testFile extends AppCompatActivity {
    private ActivityResultLauncher<Intent> startForPhoto_view_controller;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.photo_view);

        //Launchers (test/code to steal for other implementation)
        //launch_AlbumListController();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        Serialize<ArrayList<Integer>> s = new Serialize<>(
            getApplicationContext()
        );
        s.serialize(test);
        Object o1 = s.deserialize();

        try {
            ArrayList<String> star = (ArrayList<String>) o1;
            if (star.get(0) instanceof String)
                System.out.println("Sucess");
        } catch (Exception e) {
            System.out.println("fail");
        }
    }

    /*
    private void launch_AlbumListController() {
        Intent intent = new Intent(this, album_list_controller.class);
        startActivity(intent);
    }

    /*
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