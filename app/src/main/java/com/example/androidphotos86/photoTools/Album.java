package com.example.androidphotos86.photoTools;

import java.io.Serializable;
import java.util.ArrayList;

public class Album implements Serializable {
	private String albumName;
	private ArrayList<Foto> albumPhotos;

	//Initialize
	public Album() {
		albumName = "root";
		albumPhotos = new ArrayList<Photo>();
	}
	public Album(String albumName) {
		this.albumName = albumName;
		albumPhotos = new ArrayList<Photo>();
	}
	public Album(ArrayList<Photo> albumPhotos) {
		albumName = "root";
		this.albumPhotos = albumPhotos;
	}
	public Album(String albumName, ArrayList<Photo> albumPhotos) {
		this.albumName = albumName;
		this.albumPhotos = albumPhotos;
	}

	//Getters and Setters
	public void addPhoto(Photo photo) {
		albumPhotos.add(photo);
	}
	public void removePhoto(Photo photo) {
		albumPhotos.remove(photo);
	}

	public String getAlbum() {
		return albumName;
	}
}