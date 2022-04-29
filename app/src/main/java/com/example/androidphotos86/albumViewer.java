package com.example.androidphotos86;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.LinkedList;
import

public class albumViewer extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.album_list);

        LinkedList<String> list = new LinkedList<String>();
        list.add("dog");
        list.add("cat");
        System.out.println(list);

        Serialize<LinkedList<String>> serialize =
                new Serialize<LinkedList<String>>(getApplicationContext());
        serialize.serialize(list);
        LinkedList<String> list2 = serialize.deserialize();
        System.out.println(list2);
    }
}