package com.example.androidphotos86.photoTools;

import android.content.Intent;
import android.net.Uri;
import java.io.Serializable;
import java.util.ArrayList;

public class Photo {
	public Uri imageURI;
	public ArrayList<Tag> photoTags;

	public Photo(Uri imageURI) {
		this.imageURI = imageURI;
		photoTags = new ArrayList<Tag>();
	}
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