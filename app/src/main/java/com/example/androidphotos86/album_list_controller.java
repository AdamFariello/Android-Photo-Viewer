package com.example.androidphotos86;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

public class album_list_controller extends AppCompatActivity {
    private ListView albumList;
    private Button addButton, removeButton, renameButton, searchButton;
    private EditText addAlbumName, removeAlbumName, renameAlbumName, newAlbumName;

    private ArrayList<Album> albumArrayList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_list);
        Serialize<ArrayList<Album>> serialize =
                new Serialize<ArrayList<Album>>(getApplicationContext());
        albumArrayList = serialize.deserialize();

        addAlbumName = findViewById(R.id.addalbum_name);
        removeAlbumName = findViewById(R.id.removealbum_name);
        renameAlbumName = findViewById((R.id.renamealbum_name));
        newAlbumName = findViewById(R.id.newalbum_name);

        albumList = findViewById(R.id.album_list);
        albumList.setAdapter(new ArrayAdapter<Album>(this, R.layout.album_list_layout, albumArrayList));
        albumList.setOnItemClickListener((list, view, pos, id) -> showAlbum(pos));
    }

    private void renameAlbum(View view) {
        int i = 0;
        if (albumArrayList.size() == 0) {
            return;
        }
        String oldAlbumName = renameAlbumName.getText().toString();
        if (oldAlbumName.compareToIgnoreCase("") == 0) {
            return;
        }
        String newAlbumName1 = newAlbumName.getText().toString();
        if (newAlbumName1.compareToIgnoreCase("") == 0) {
            return;
        }

        for (i = 0; i < albumArrayList.size(); i++) {
            if (oldAlbumName.compareToIgnoreCase(albumArrayList.get(i).albumName) == 0) {
                albumArrayList.get(i).albumName=newAlbumName1;
            }
        }
        Serialize<ArrayList<Album>> serialize =
                new Serialize<ArrayList<Album>>(getApplicationContext());
        serialize.serialize(albumArrayList);
        albumList.setAdapter(new ArrayAdapter<Album>(this, R.layout.album_list_layout, albumArrayList));
    }

    private void addAlbum(View view) {

        if (addAlbumName.getText().toString() == "") {
            return;
        }
        Album newAlbum = new Album(addAlbumName.getText().toString());
        for (int i = 0; i < albumArrayList.size(); i++) {
            if (newAlbum.albumName.compareToIgnoreCase(albumArrayList.get(i).albumName) == 0)
                return;
        }
        albumArrayList.add(newAlbum);
        Serialize<ArrayList<Album>> serialize =
                new Serialize<ArrayList<Album>>(getApplicationContext());
        serialize.serialize(albumArrayList);
        albumList.setAdapter(new ArrayAdapter<Album>(this, R.layout.album_list_layout, albumArrayList));
    }

    private void removeAlbum(View view) {
        int i = 0;
        if (albumArrayList.size() == 0) {
            return;
        }
        String albumName = removeAlbumName.getText().toString();
        if (albumName.compareToIgnoreCase("") == 0)
            return;

        for (i = 0; i < albumArrayList.size(); i++) {
            if (albumName.compareToIgnoreCase(albumArrayList.get(i).albumName) == 0) {
                albumArrayList.remove(i);
                Serialize<ArrayList<Album>> serialize =
                        new Serialize<ArrayList<Album>>(getApplicationContext());
                serialize.serialize(albumArrayList);
                albumList.setAdapter(new ArrayAdapter<Album>(this, R.layout.album_list_layout, albumArrayList));
                return;

            } else
                continue;
        }
        if (i == albumArrayList.size()) {
            return;
        }
    }

    private void goToSearch(View view) {
        Intent intent = new Intent(this, photo_searched_controller.class);
        startActivity(intent);
    }

    private void showAlbum(int pos){
        // launch for edit
        Intent intent = new Intent(this, photo_list_controller.class);
        startActivity(intent);

    }
}
