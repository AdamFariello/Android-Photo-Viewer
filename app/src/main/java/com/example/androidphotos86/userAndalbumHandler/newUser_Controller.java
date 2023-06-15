package com.example.androidphotos86.userAndalbumHandler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidphotos86.R;
import com.example.androidphotos86.photoTools.*;
import com.example.androidphotos86.tools.*;

import java.util.ArrayList;

public class newUser_Controller extends AppCompatActivity {
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user);
    }
    public void bt_NewUser(View view) {
        Serialize<ArrayList<Album>> serialize = new Serialize<>(
            getApplicationContext()
        );
        serialize.serialize(new ArrayList<Album>());
        bt_OldUser(view);
    }
    public void bt_OldUser(View view) {
        try {
            Intent intent = new Intent(
            this, album_list_controller.class
            );
            startActivity(intent);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}