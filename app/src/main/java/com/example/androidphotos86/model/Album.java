package com.example.androidphotos86.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Album implements Serializable {
	static final long serialVersionUID = 1L;

	public static final String storeDir = "dat";
	public static final String storeFile = "users.dat";
	public String albumName;
	public ArrayList<Photo> albumPhotos;

	public Album(String albumName) {
		this.albumPhotos = new ArrayList<Photo>();
		this.albumName = albumName;
	}

	public String getAlbum(String albumName) {
		return this.albumName;
	}

	public String toString() {
		return this.albumName;
	}
}