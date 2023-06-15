package com.example.androidphotos86.photoHandler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidphotos86.R;

import com.example.androidphotos86.photoTools.*;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class photo_list_controller extends AppCompatActivity {
    public static final String ALBUM_INDEX = "albumIndex";
    public static final String ALBUM_NAME = "albumName";
    private static final int REQUEST_IMAGE_GET = 1;
    private int index;

    private Button addPhotoButton, removePhotoButton;
    private ArrayList<Album> albumArrayList;
    private GridView photoGrid;
    private ImageAdapter imageAdapter;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_list);
        
        try{
            albumArrayList= new ArrayList<Album>();
            albumArrayList=load();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            index = bundle.getInt(ALBUM_INDEX);
        }
        addPhotoButton = findViewById(R.id.addPhotoButton);
        removePhotoButton = findViewById(R.id.removePhotoButton);
        imageAdapter = new ImageAdapter(this,albumArrayList.get(index).albumPhotos);
        photoGrid= findViewById(R.id.photoGrid);
        photoGrid.setAdapter(imageAdapter);
    }

    public void addPhoto(View view){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET);
        }
        try{
            save(albumArrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_GET && resultCode == Activity.RESULT_OK) {
            Uri uri = null;
            if (data != null) {
                uri = data.getData();
                for (int i = 0; i < albumArrayList.get(index).albumPhotos.size(); i++) {
                    if (uri.equals(albumArrayList.get(index).albumPhotos.get(i).getUri())) {
                        return;
                    }
                }
            }
                albumArrayList.get(index).albumPhotos.add(new Photo(uri));
                try {
                    save(albumArrayList);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                imageAdapter = new ImageAdapter(this, albumArrayList.get(index).albumPhotos);
                photoGrid = findViewById(R.id.photoGrid);
                photoGrid.setAdapter(imageAdapter);
            }
        }



    public void removePhoto(View view){

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
