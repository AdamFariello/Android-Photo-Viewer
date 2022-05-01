package com.example.androidphotos86.fotoTools;

import android.content.Intent;
import android.net.Uri;
import java.io.Serializable;
import java.util.ArrayList;

public class Foto implements Serializable {
	private Uri imageURI;
	private ArrayList<Tag> fotoTags;

	public Foto(Intent data) {
		imageURI = data.getData();
		fotoTags = new ArrayList<Tag>();
	}

	public Uri getUri () {
		return imageURI;
	}
	public ArrayList<Tag> getTags () {
		return fotoTags;
	}
	public String toString() {
		return "ImageUri: " + imageURI + "\ntags: " +fotoTags;
	}
}