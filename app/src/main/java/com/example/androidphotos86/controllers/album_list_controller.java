package com.example.androidphotos86.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidphotos86.R;
import com.example.androidphotos86.photoTools.Album;
import com.example.androidphotos86.tools.Serialize;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class album_list_controller extends AppCompatActivity {
    private ListView albumList;
    private Button addButton, removeButton, renameButton, searchButton;
    private EditText addAlbumName, removeAlbumName, renameAlbumName, newAlbumName;
    File file = new File("/data/data/com.example.androidphotos86/files/data.dat");
    private ArrayList<String> albumStrings;
    private ArrayList<Album> albumArrayList;

    protected void onCreate(Bundle savedInstanceState) {
        try {albumArrayList = new ArrayList<Album>();
            albumStrings = new ArrayList<String>();
             albumArrayList= load();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_list);
        albumToString();
        addButton= findViewById(R.id.button);
        removeButton = findViewById(R.id.removeButton);
        renameButton = findViewById(R.id.renameButton);
        searchButton= findViewById(R.id.searchButton);
        addAlbumName = findViewById(R.id.addalbum_name);
        removeAlbumName = findViewById(R.id.removealbum_name);
        renameAlbumName = findViewById((R.id.renamealbum_name));
        newAlbumName = findViewById(R.id.newalbum_name);

        albumList = findViewById(R.id.album_list);
        albumList.setAdapter(new ArrayAdapter<String>(this, R.layout.album_list_layout, albumStrings));
        albumList.setOnItemClickListener((list, view, pos, id) -> showAlbum(pos));
    }

    private void albumToString() {
        albumStrings.clear();
        for (Album a : albumArrayList) {
            albumStrings.add(a.albumName);
        }
    }

    public void renameAlbum(View view) {
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
            if (oldAlbumName.compareToIgnoreCase(albumArrayList.get(i).albumName) == 0)
                albumArrayList.get(i).albumName=newAlbumName1;
        }
        try {
          save(albumArrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        albumToString();
        albumList.setAdapter(new ArrayAdapter<String>(this, R.layout.album_list_layout, albumStrings));
    }

    public void addAlbum(View view) {
        if (addAlbumName.getText().toString().equals("")) {
            return;
        }
        Album newAlbum = new Album(addAlbumName.getText().toString());
        for (int i = 0; i < albumArrayList.size(); i++) {
            if (newAlbum.albumName.compareToIgnoreCase(albumArrayList.get(i).albumName) == 0)
                return;
        }
        albumArrayList.add(newAlbum);
        try {
            save(albumArrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        albumToString();
        albumList.setAdapter(new ArrayAdapter<String>(this, R.layout.album_list_layout, albumStrings));
    }

    public void removeAlbum(View view) {
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
                try {
                    save(albumArrayList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                albumToString();
                albumList.setAdapter(new ArrayAdapter<String>(this, R.layout.album_list_layout, albumStrings));
                return;

            } else
                continue;
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
        bundle.putString(photo_list_controller.ALBUM_NAME, albumArrayList.get(pos).albumName);
        Intent intent = new Intent(this, photo_list_controller.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
    private void save(ArrayList<Album> albums) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("/data/data/com.example.androidphotos86/files/data.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(albums);
        oos.close();
        fileOutputStream.close();

    }

    private ArrayList<Album> load()
            throws IOException, EOFException, ClassNotFoundException {
        File myFile = new File("/data/data/com.example.androidphotos86/files/data.dat");
        ArrayList<Album> albums = new ArrayList<Album>();
        if (myFile.length()>0) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(myFile));
            albums = (ArrayList<Album>)ois.readObject();
            ois.close();

        }
        return albums;
    }
}