package com.example.androidphotos86.photoTools;

import android.content.Intent;
import android.net.Uri;
import java.io.Serializable;
import java.util.ArrayList;

public class Photo {
	private Uri imageURI;
	private ArrayList<Tag> photoTags;

	public Photo(Intent data) {
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