package com.example.androidphotos86;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import com.example.androidphotos86.fotoTools.*;

public class testFile extends AppCompatActivity {
    private ActivityResultLauncher<Intent> startForfoto_view_controller;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.foto_view);

        //Launchers (test/code to steal for other implementation)
        //launch_AlbumListController();

        ArrayList<Foto> fotos = new ArrayList<Foto>();
        //fotos.add(null);
        ArrayList<String> s = ArrayList<String>();
        s.add("cat");
    }

    /*
    private void launch_AlbumListController() {
        Intent intent = new Intent(this, album_list_controller.class);
        startActivity(intent);
    }

    private void launch_fotoListController() {
        Intent intent = new Intent(this, foto_list_controller.class);
        startActivity(intent);
    }

    private void launch_fotoViewController() {
        Intent intent = new Intent(this, foto_view_controller.class);
        startActivity(intent);
    }
     */
}