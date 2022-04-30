package com.example.androidphotos86;

import android.content.Intent;
import android.net.Uri;
import java.io.Serializable;
import java.util.ArrayList;

public class Photo implements Serializable {
	private Uri imageURI;
	private ArrayList<Tag> photoTags;

	public Photo(Intent data) {
		//TODO Figure out what the codes are for
		//
		/*
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){

		} else {
			System.out.println("[DEBUG] Photo.Photo");
			System.out.println("parameters wrong");
		}
		*/

		imageURI = data.getData();
		photoTags = new ArrayList<Tag>();
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