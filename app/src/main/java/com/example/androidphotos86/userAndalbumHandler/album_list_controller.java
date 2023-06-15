package com.example.androidphotos86.userAndalbumHandler;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidphotos86.R;
import com.example.androidphotos86.photoHandler.photo_list_controller;
import com.example.androidphotos86.photoSearch.photo_searched_controller;
import com.example.androidphotos86.photoTools.*;
import com.example.androidphotos86.tools.Serialize;

import java.util.ArrayList;

public class album_list_controller extends AppCompatActivity {
    private ListView albumList;
    private EditText addAlbumName, removeAlbumName, renameAlbumName, newAlbumName;

    private ArrayList<String> albumStrings;
    private ArrayList<Album> albumArrayList;
    private Serialize<ArrayList<Album>> serialize;

    protected void onCreate(Bundle savedInstanceState) {
        //Start
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_list);
        addAlbumName    = (EditText) findViewById(R.id.addAlbumName);
        removeAlbumName = (EditText) findViewById(R.id.removeAlbumName);
        renameAlbumName = (EditText) findViewById(R.id.renameAlbumName);
        newAlbumName    = (EditText) findViewById(R.id.newAlbumName);

        //Loading List
        serialize = new Serialize<>(getApplicationContext());
        albumArrayList = serialize.deserialize();
        albumStrings = new ArrayList<String>();
        albumToString();

        //AlbumList
        albumList = findViewById(R.id.album_list);
        albumList.setAdapter(new ArrayAdapter<String>(
        this, R.layout.album_list_layout, albumStrings)
        );
        albumList.setOnItemClickListener(
            (list, view, pos, id) -> showAlbum(pos)
        );
    }

    private void albumToString() {
        albumStrings.clear();
        for (Album a : albumArrayList)
            albumStrings.add(a.albumName);
    }

    public void renameAlbum(View view) {
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

        for (int i = 0; i < albumArrayList.size(); i++) {
            if (oldAlbumName.compareToIgnoreCase(albumArrayList.get(i).albumName) == 0)
                albumArrayList.get(i).albumName=newAlbumName1;
        }
        try {
            serialize.serialize(albumArrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        albumToString();
        albumList.setAdapter(new ArrayAdapter<String>(this, R.layout.album_list_layout, albumStrings));
    }

    public void addAlbum(View view) {
        if (addAlbumName.getText().toString().equals(""))
            return;

        Album newAlbum = new Album(addAlbumName.getText().toString());
        for (int i = 0; i < albumArrayList.size(); i++)
            if (newAlbum.albumName.compareToIgnoreCase(albumArrayList.get(i).albumName) == 0)
                return;
        albumArrayList.add(newAlbum);
        serialize.serialize(albumArrayList);

        albumToString();
        albumList.setAdapter(new ArrayAdapter<String>(
            this, R.layout.album_list_layout, albumStrings)
        );
    }

    public void removeAlbum(View view) {
        if (albumArrayList.size() == 0) {
            return;
        }
        String albumName = removeAlbumName.getText().toString();
        if (albumName.compareToIgnoreCase("") == 0)
            return;

        int i;
        for (i = 0; i < albumArrayList.size(); i++) {
            if (albumName.compareToIgnoreCase(albumArrayList.get(i).albumName) == 0) {
                albumArrayList.remove(i);
                try {
                    serialize.serialize(albumArrayList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                albumToString();
                albumList.setAdapter(new ArrayAdapter<String>(this, R.layout.album_list_layout, albumStrings));
                return;
            }
        }
        if (i == albumArrayList.size()) {
            return;
        }
    }

    public void goToSearch(View view) {
        Intent intent = new Intent(this, photo_searched_controller.class);
        startActivity(intent);
    }

    public void showAlbum(int pos){
        // launch for edit
        Bundle bundle = new Bundle();
        bundle.putInt(photo_list_controller.ALBUM_INDEX, pos);
        bundle.putString(
            photo_list_controller.ALBUM_NAME,
            albumArrayList.get(pos).albumName
        );
        Intent intent = new Intent(
        this, photo_list_controller.class
        );
        intent.putExtras(bundle);
        startActivity(intent);
    }
}