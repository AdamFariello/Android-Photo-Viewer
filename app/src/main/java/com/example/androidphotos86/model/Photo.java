package com.example.androidphotos86.model;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import java.io.Serializable;
import java.util.ArrayList;

public class Photo implements Serializable {
	private Uri imageURI;
	private ArrayList<Tag> photoTags;
	private static final int PICK_IMAGE = 100;

	public Photo(int requestCode, int resultCode, Intent data) {
		//TODO ?
		//super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
			imageURI = data.getData();
			photoTags = new ArrayList<Tag>();
		} else {
			System.out.println("[DEBUG] Photo.Photo");
			System.out.println("parameters wrong");
		}
	}
	public Photo(Uri uri){
		this.imageURI=uri;
		photoTags= new ArrayList<Tag>();
	}

	public Uri getUri () {
		return imageURI;
	}
	public ArrayList<Tag> getTags () {
		return photoTags;
	}
	public String toString() {
		return "ImageUri: " + imageURI + "\ntags: " +photoTags;
	}
}