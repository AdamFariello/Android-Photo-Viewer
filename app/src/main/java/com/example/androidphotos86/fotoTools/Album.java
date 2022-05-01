package com.example.androidphotos86.fotoTools;

import java.io.Serializable;
import java.util.ArrayList;

public class Album implements Serializable {
	private String albumName;
	private ArrayList<Foto> albumFotos;

	//Initialize
	public Album() {
		albumName = "root";
		albumFotos = new ArrayList<Foto>();
	}
	public Album(String albumName) {
		this.albumName = albumName;
		albumFotos = new ArrayList<Foto>();
	}
	public Album(ArrayList<Foto> albumfotos) {
		albumName = "root";
		this.albumFotos = albumfotos;
	}
	public Album(String albumName, ArrayList<Foto> albumfotos) {
		this.albumName = albumName;
		this.albumfotos = albumfotos;
	}

	//Getters and Setters
	public void addfoto(Foto foto) {
		albumFotos.add(foto);
	}
	public void removefoto(Foto foto) {
		albumFotos.remove(foto);
	}

	public String getAlbum() {
		return albumName;
	}
}